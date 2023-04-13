package com.techevents.apiService.controllers;


import com.techevents.domain.models.Event;
import com.techevents.infrastructure.repositories.IEventRepository;
import com.techevents.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Event>> getAll(){
    return ResponseEntity.ok(this.eventService.findAll());
}

@GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable Long id){ return ResponseEntity.ok(this.eventService.getById(id));
}

}
