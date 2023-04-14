package com.techevents.service;

import com.techevents.domain.dtos.EventRequest;
import com.techevents.domain.models.Event;
import com.techevents.infrastructure.repositories.ICategoryRepository;
import com.techevents.infrastructure.repositories.IEventRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service

public class EventService {

private final IEventRepository eventRepository;
private final ICategoryRepository categoryRepository;

    public EventService(IEventRepository eventRepository, ICategoryRepository categoryRepository) {
        this.eventRepository = eventRepository;
        this.categoryRepository = categoryRepository;
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

    public List<Event> findEventByCategory(@PathVariable Long id){
        return eventRepository.findByCategory_Id(id);
    }

    public Event create(EventRequest request) {
        var category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));


        // var author = this.authService.getAuthAuth();
        var event= new Event();
        event.setCategory(category);
        event.setUrlImage(request.getUrlImage());
        event.setTitle(request.getTitle());
        event.setDegree(request.getDegree());
        event.setEventDate(request.getEventDate());
        event.setEventTime(request.getEventTime());
        event.setCapacity(request.getCapacity());
        event.setHighlight(request.getHighlight());
        event.setDescription(request.getDescription());


        return this.eventRepository.save(event);
    }
}
