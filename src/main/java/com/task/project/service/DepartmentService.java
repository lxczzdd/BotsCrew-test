package com.task.project.service;


import com.task.project.entity.Department;
import com.task.project.entity.Lector;
import com.task.project.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public void getHead(String line) {
        String[] lineArray = line.split(" ");
        if (lineArray.length == 6) {
            String departmentName = lineArray[lineArray.length - 1];
            if (departmentName == null || departmentName.equals(""))
                System.out.println("Department with name " + departmentName + " not found");
            Department foundDepartment = departmentRepository.findByName(departmentName);
            if (foundDepartment != null) {
                System.out.println("Answer: Head of " + departmentName + " department is " + foundDepartment.getLectors().get(0).getName());
            } else
                System.out.println("Department with name " + departmentName + " not found");
        } else
            System.out.println("Wrong question, try again or type 'EXIT'");
    }

    public void showStatistics(String line) {
        String[] lineArray = line.split(" ");
        if (lineArray.length == 3) {
            String departmentName = lineArray[1];
            if (departmentName == null || departmentName.equals(""))
                System.out.println("Department with name " + departmentName + " not found");
            else {
                Department foundDepartment = departmentRepository.findByName(departmentName);
                if (foundDepartment != null) {
                    System.out.println("Answer: assistants - " + foundDepartment.getLectors().stream()
                            .filter(x -> x.getDegree().getName().equals("assistant"))
                            .count());
                    System.out.println("associate professors - " + foundDepartment.getLectors().stream()
                            .filter(x -> x.getDegree().getName().equals("associate professor"))
                            .count());
                    System.out.println("professors - " + foundDepartment.getLectors().stream()
                            .filter(x -> x.getDegree().getName().equals("professor"))
                            .count());
                } else
                    System.out.println("Department with name " + departmentName + " not found");
            }
        } else
            System.out.println("Wrong question, try again or type 'EXIT'");
    }

    public void showAverageSalary(String line) {
        String[] lineArray = line.split(" ");
        if (lineArray.length == 8) {
            String departmentName = lineArray[lineArray.length - 1];
            if (departmentName == null || departmentName.equals(""))
                System.out.println("Department with name " + departmentName + " not found");
            Department foundDepartment = departmentRepository.findByName(departmentName);
            if (foundDepartment != null) {
                System.out.println("Answer: The average salary of " + departmentName + " is " + foundDepartment.getLectors()
                        .stream()
                        .mapToDouble(Lector::getSalary)
                        .average()
                        .orElse(0.0));
            } else
                System.out.println("Department with name " + departmentName + " not found");
        } else
            System.out.println("Wrong question, try again or type 'EXIT'");
    }

    public void showCountOfEmployees(String line) {
        String[] lineArray = line.split(" ");
        if (lineArray.length == 6) {
            String departmentName = lineArray[lineArray.length - 1];
            if (departmentName == null || departmentName.equals(""))
                System.out.println("Department with name " + departmentName + " not found");
            Department foundDepartment = departmentRepository.findByName(departmentName);
            if (foundDepartment != null) {
                System.out.println("Answer: " + foundDepartment.getLectors().size());
            } else
                System.out.println("Department with name " + departmentName + " not found");
        } else
            System.out.println("Wrong question, try again or type 'EXIT'");
    }

    public void globalSearchByTemplate(String line) {
        String[] lineArray = line.split(" ");
        if (lineArray.length == 4) {
            String template = lineArray[lineArray.length - 1];
            List<List<String>> result = departmentRepository.findAll().stream()
                    .map(x -> x.getLectors()
                            .stream()
                            .map(Lector::getName)
                            .filter(name -> name.contains(template))
                            .toList())
                    .toList();
            StringBuilder toOutput = new StringBuilder();
            for (var x : result) {
                toOutput.append(x);
            }
            System.out.println("Answer: " + toOutput.toString().replaceAll("\\[|\\]", ""));
        } else
            System.out.println("Wrong question, try again or type 'EXIT'");
    }
}
