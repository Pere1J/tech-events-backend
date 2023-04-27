package com.techevents.service;

import com.techevents.domain.models.Event;
import com.techevents.infrastructure.repositories.IEventRepository;
import com.techevents.security.auth.AuthFacade;
import com.techevents.security.user.User;
import com.techevents.security.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final IEventRepository eventRepository;
    private final AuthFacade authFacade;

    public UserService(UserRepository userRepository, IEventRepository eventRepository, AuthFacade authFacade) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.authFacade = authFacade;
    }

    public User getByName (String name){
    return this.userRepository.getByName(name).get();
    }
    //public List<Event> findAllEventsByUser(User user) {
      //  return this.eventRepository.findByInscribedUsers_User_Id(user.getId());}
    public List<Event> findAllEventsByUser(User user) {
        var auth = authFacade.getOptionalAuthUser();
        if (auth.isPresent() && auth.get().equals(user)) {
            return this.eventRepository.findByInscribedUsers_User_Id(user.getId());
        } else {
            return Collections.emptyList();
        }
    }



}
