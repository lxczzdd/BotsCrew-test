package com.task.project;

import com.task.project.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;
import java.util.Scanner;

@SpringBootApplication
@RequiredArgsConstructor
public class ProjectApplication implements CommandLineRunner {

    private final DepartmentService departmentService;

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner in = new Scanner(System.in);
        String line = null;
        while (!Objects.equals(line, "EXIT")) {
            System.out.print("User Input: ");
            line = in.nextLine();

            if (line.startsWith("Who is head of department")) {
                departmentService.getHead(line);
            }
            else if (line.startsWith("Show") && line.endsWith("statistics")) {
                departmentService.showStatistics(line);
            }
            else if (line.startsWith("Show the average salary for the department")) {
                departmentService.showAverageSalary(line);
            }
            else if (line.startsWith("Show count of employee for")) {
                departmentService.showCountOfEmployees(line);
            }
            else if (line.startsWith("Global search by")) {
                departmentService.globalSearchByTemplate(line);
            }
            else
                System.out.println("Wrong question, try again or type 'EXIT'");

        }
    }
}
