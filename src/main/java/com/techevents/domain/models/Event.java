package com.techevents.domain.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


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
    private String nivel;
    private LocalDate fecha;
    private LocalTime hora;
    private Long capacity;
    private Boolean highlight;
    private Boolean active;

    @Column(length = 1000)
    private String description;



    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;







}
