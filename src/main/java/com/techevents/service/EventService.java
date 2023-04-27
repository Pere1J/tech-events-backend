package com.techevents.service;

import com.techevents.domain.dtos.EventRequest;
import com.techevents.domain.models.Event;
import com.techevents.infrastructure.repositories.ICategoryRepository;
import com.techevents.infrastructure.repositories.IEventRepository;
import com.techevents.security.auth.AuthFacade;
import com.techevents.security.user.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class EventService {

private final IEventRepository eventRepository;
private final ICategoryRepository categoryRepository;
private final AuthFacade authFacade;


    public EventService(IEventRepository eventRepository, ICategoryRepository categoryRepository, AuthFacade authFacade) {
        this.eventRepository = eventRepository;
        this.categoryRepository = categoryRepository;
        this.authFacade = authFacade;

    }

//esto funciona solo si el usr está autenticado

    public List<Event> findAll() {

       var auth = authFacade.getOptionalAuthUser();
        var eventList = this.eventRepository.findAll();
        if (auth.isPresent()){
            eventList.forEach(event -> {
            event.isUserInscribed(auth.get());
            });
        }

       return eventList;
    }



    public Event getById(Long id) {
        //return this.eventRepository.findById(id).get();
        var auth = authFacade.getOptionalAuthUser();
        var eventOptional = this.eventRepository.findById(id);
        if(eventOptional.isEmpty()){throw new RuntimeException("Evento no encontrado");}
        var event = eventOptional.get();
        if(auth.isPresent()){event.isUserInscribed(auth.get());}

        return event;
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

    public void deleteById(Long id) {
        this.eventRepository.deleteById(id);
    }

    public void RegisterUserForEvent(User user, Event event)  {event.addUserRegister(user);
    }

    public void editById(Long eventId, EventRequest newEvent){

        var event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
        var category = categoryRepository.findById(newEvent.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));

        event.setUrlImage(newEvent.getUrlImage());
        event.setTitle(newEvent.getTitle());
        event.setDegree(newEvent.getDegree());
        event.setEventDate(newEvent.getEventDate());
        event.setEventTime(newEvent.getEventTime());
        event.setCapacity(newEvent.getCapacity());
        event.setHighlight(newEvent.getHighlight());
        event.setDescription(newEvent.getDescription());
        event.setCategory(category);
        eventRepository.save(event);
    }
}
