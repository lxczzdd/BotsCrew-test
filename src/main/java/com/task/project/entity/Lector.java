package com.task.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "lectors")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer salary;

    @ManyToOne
    private Degree degree;

    public Lector(String name) {
        this.name = name;
    }
}
