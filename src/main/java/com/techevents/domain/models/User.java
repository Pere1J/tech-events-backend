package com.techevents.domain.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Users")
@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String password;

}
