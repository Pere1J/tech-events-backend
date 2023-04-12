package com.techevents.domain.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="categories")

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;
    private String name;
}
