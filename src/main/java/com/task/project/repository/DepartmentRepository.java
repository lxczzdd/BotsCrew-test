package com.task.project.repository;

import com.task.project.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByName(String name);
}

