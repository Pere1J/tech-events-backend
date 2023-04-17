package com.techevents.domain.dtos;


import com.techevents.domain.models.Event;
import com.techevents.security.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class EventUserRequest {


    // Users
    @ManyToOne(cascade = CascadeType.PERSIST )
    @JoinColumn(name = "user_id")
    private User user;

    // Events
    @ManyToOne(cascade = CascadeType.PERSIST )
    @JoinColumn(name = "event_Id")
    private Event event;



}
