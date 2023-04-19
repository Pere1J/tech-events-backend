package com.techevents.domain.models;

import com.techevents.security.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inscribedUsers")
@Data
@NoArgsConstructor
public class InscribedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public InscribedUser(User user, Event event) {
        this.user = user;
        this.event = event;
    }

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

}
