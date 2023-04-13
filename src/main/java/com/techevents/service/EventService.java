package com.techevents.service;

import com.techevents.domain.models.Event;
import com.techevents.infrastructure.repositories.IEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EventService {

private final IEventRepository eventRepository;

    public EventService(IEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public List<Event> findAll(){return this.eventRepository.findAll();
    }


    public Event getById(Long id) {
        //return this.eventRepository.findById(id).get();
        var eventOptional = this.eventRepository.findById(id);
        if(eventOptional.isEmpty())throw new RuntimeException("Evento no encontrado");
        return eventOptional.get();
    }
    public List<Event> getAllHighlight(){
        return this.eventRepository.findByHighlightTrueOrderByEventDateAsc();
    }
}
