package com.task.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Lector> lectors;

    public Department(String name) {
        this.name = name;
    }
}
