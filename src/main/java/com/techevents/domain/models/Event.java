package com.techevents.domain.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;


@Entity
@Table(name="events")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)


    private Long id;
    private String urlImage;
    private String title;
    private String level;
    private Date date;
    private Time hour;
    private Long capacity;
    private String description;



    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;



}
