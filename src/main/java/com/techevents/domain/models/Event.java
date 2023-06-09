package com.techevents.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.techevents.security.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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

@Transient
    private Boolean isInscribedUser = false;




    //UserControl
   @JsonIgnore
    @ManyToMany(mappedBy = "events", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;

    public void addUserRegister(User user) {

        users.add(user);

    }
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "event_id")
    private List<InscribedUser>inscribedUsers = new ArrayList<>();

    @JsonProperty

    public int inscribedUsersCount(){
        return this.inscribedUsers.size();
    }


    public  Boolean isUserInscribed(User user) {
        if (inscribedUsers.stream().anyMatch(inscribedUser -> inscribedUser.getUser().equals(user))) {
            this.isInscribedUser = true;
            return true;
        };
        this.isInscribedUser = false;
        return false;
    }

    @JsonProperty
    public boolean isFull() {
        return inscribedUsers.size() >= capacity;
    }


}
