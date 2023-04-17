package com.techevents.domain.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.techevents.security.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


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
    private String degree;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private Long capacity;
    private Boolean highlight;


    @JsonSerialize
    public Boolean active(){
        LocalDate actualDate = LocalDate.now();

       return eventDate.isAfter(actualDate) || eventDate.isEqual(actualDate);

    };

    @Column(length = 1000)
    private String description;



    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;






    //UserControl
    @ManyToMany(mappedBy = "events")
    private List<User> users;






}
