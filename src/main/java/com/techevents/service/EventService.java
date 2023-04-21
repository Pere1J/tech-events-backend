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

       //var auth = authFacade.getAuthUser();
        var eventList = this.eventRepository.findAll();
//        eventList.forEach(event -> {
//            event.isUserInscribed(auth);
//        });
       return eventList;
    }



// esta verificación no funciona
//    public List<Event> findAll() {
//        var auth = authFacade.getAuthUser();
//        var eventList = this.eventRepository.findAll();
//        if (authFacade.getAuthUser() == null) {
//            return eventList;
//        } else {
//            eventList.forEach(event -> {
//                event.isUserInscribed(auth);
//            });
//            return eventList;
//        }
//    }

  //esta verificacion tampoco funciona
//  public List<Event> findAll() {
//        var auth = authFacade.getAuthUser();
//        var eventList = this.eventRepository.findAll();
//        if (Optional.ofNullable(auth).isPresent()) {
//            eventList.forEach(event -> {
//                event.isUserInscribed(auth);
//            });
//        }
//        return eventList;
//    }

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

    public void deleteById(Long id) {
        this.eventRepository.deleteById(id);
    }

    public void RegisterUserForEvent(User user, Event event)  {event.addUserRegister(user);
    }
}
