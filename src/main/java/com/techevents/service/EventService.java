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


}
