package com.techevents.apiService.controllers;


import com.techevents.domain.dtos.EventRequest;
import com.techevents.domain.models.Event;
import com.techevents.infrastructure.repositories.IEventRepository;
import com.techevents.security.auth.AuthFacade;
import com.techevents.security.user.User;
import com.techevents.service.EventService;
import com.techevents.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public eventController(AuthFacade authFacade, EventService eventService, IEventRepository eventRepository, UserService userService) {
        this.authFacade = authFacade;
        this.eventService = eventService;
        this.eventRepository = eventRepository;
        this.userService = userService;
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
    public ResponseEntity<String>  registerForEvent(@PathVariable("eventId") Long eventId) {
       // Obtener el evento por su ID
        Event event = eventService.getById(eventId);

        // Comprobar si el usuario está autenticado
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            // El usuario está autenticado, obtener su nombre de usuario
            String username = auth.getName();

            // Buscar el usuario por su nombre de usuario
            User user = userService.getByName(username);

            // Registrar al usuario en el evento
            eventService.RegisterUserForEvent(user, event);


           // Redirigir a la vista de confirmación de registro
            return ResponseEntity.ok("Event registration successful");
        } else {
            // El usuario no está autenticado, redirigir a la página de inicio de sesión
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).header("Location", "/login").build();
        }
    }
    @GetMapping("/test")
    @PreAuthorize("hasAuthority('USER')")
    public User test(){
      return this.authFacade.getAuthUser();

    }

}
