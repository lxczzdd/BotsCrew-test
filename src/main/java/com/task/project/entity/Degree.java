package com.task.project.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "degrees")
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @OneToMany(mappedBy = "degree")
    private List<Lector> lectors;

    public Degree(String name) {
        this.name = name;
    }
}
