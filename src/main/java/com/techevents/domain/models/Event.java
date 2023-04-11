package com.techevents.domain.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;


@Entity
@Table(name="events")
@Data
public class Event {


    private Long id;
    private String title;
    private Long capacity;
    private String urlImage;
    private Date date;
    private Time hour;



}
