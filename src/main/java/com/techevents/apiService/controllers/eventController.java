package com.techevents.apiService.controllers;


import com.techevents.domain.models.Event;
import com.techevents.infrastructure.repositories.IEventRepository;
import com.techevents.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin ("*")
@RequestMapping("/events")

public class eventController {

private final EventService eventService;
private final IEventRepository eventRepository;

    public eventController(EventService eventService, IEventRepository eventRepository) {
        this.eventService = eventService;
        this.eventRepository = eventRepository;
    }

@GetMapping
    //public ResponseEntity<List<Event>> getAll(){return ResponseEntity.ok(this.eventService.findAll());}
    public ResponseEntity<List<Event>> getAll(){
        List<Event> eventos = this.eventRepository.findAll(); eventos.sort(Comparator.comparing(Event::getEventDate));
        return ResponseEntity.ok(eventos);}

    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable Long id){ return ResponseEntity.ok(this.eventService.getById(id));}

@GetMapping("/highlight")
    public ResponseEntity<List<Event>> getAllHighlight() {return ResponseEntity.ok(this.eventService.getAllHighlight());}

}
