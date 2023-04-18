package com.techevents.apiService.controllers;


import com.techevents.domain.dtos.EventRequest;
import com.techevents.domain.models.Event;
import com.techevents.infrastructure.repositories.IEventRepository;
import com.techevents.security.auth.AuthFacade;
import com.techevents.security.user.User;
import com.techevents.security.user.UserRepository;
import com.techevents.service.EventService;
import com.techevents.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin ("*")
@RequestMapping("/events")


public class eventController {
    private final AuthFacade authFacade;

    private final EventService eventService;
    private final IEventRepository eventRepository;
    private final UserService userService;
    private  final UserRepository userRepository;

    public eventController(AuthFacade authFacade, EventService eventService, IEventRepository eventRepository, UserService userService, UserRepository userRepository) {
        this.authFacade = authFacade;
        this.eventService = eventService;
        this.eventRepository = eventRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    //public ResponseEntity<List<Event>> getAll(){return ResponseEntity.ok(this.eventService.findAll());}
    public ResponseEntity<List<Event>> getAll() {
        List<Event> eventList = this.eventRepository.findAll();
        eventList.sort(Comparator.comparing(Event::getEventDate));
        return ResponseEntity.ok(eventList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.eventService.getById(id));
    }
    @GetMapping("/highlight")
    public ResponseEntity<List<Event>> getAllHighlight() {
        return ResponseEntity.ok(this.eventService.getAllHighlight());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Event>> findEventByCategory(@PathVariable Long id) {
        return ResponseEntity.ok(this.eventService.findEventByCategory(id));

    }

    @PostMapping
    //----> añadimos la necesidad de usuario autorizado
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Event> create(@RequestBody EventRequest request){

        return ResponseEntity.ok(this.eventService.create(request));

    }


    @DeleteMapping("/{id}")
    //----> añadimos la necesidad de usuario autorizado
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void deleteById(@PathVariable Long id){
        this.eventService.deleteById(id);
    }
    @PostMapping("/{id}/register")
    @Transactional
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Event> registerForEvent(@PathVariable Long id) {
        User currentUser = this.authFacade.getAuthUser();

        Event event = this.eventService.getById(id);

        event.addUserRegister(currentUser);
        currentUser.getEvents().add(event);
        this.userRepository.save(currentUser);
        this.eventRepository.save(event);
        return ResponseEntity.ok(event);
    }


    @GetMapping("/test")
    @PreAuthorize("hasAuthority('USER')")
    public User test(){
      return this.authFacade.getAuthUser();

    }

}
