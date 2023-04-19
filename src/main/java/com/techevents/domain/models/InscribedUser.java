package com.techevents.domain.models;

import com.techevents.security.user.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inscribedUsers")
@Data
public class InscribedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

}
