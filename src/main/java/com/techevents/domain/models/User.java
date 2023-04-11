package com.techevents.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Users")
@Data

public class User {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String password;

}
