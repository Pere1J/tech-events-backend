package com.techevents.domain.dtos;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class EventRequest {

    private String urlImage;
    private String title;
    private String degree;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private Long capacity;
    private Boolean highlight;
    private Long categoryId;
    @Column(length = 1000)
    private String description;





}
