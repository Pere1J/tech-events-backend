package com.techevents.service;

import com.techevents.domain.models.InscribedUser;
import com.techevents.infrastructure.repositories.IEventRepository;
import com.techevents.infrastructure.repositories.IInscribedUserRepository;
import com.techevents.security.auth.AuthFacade;
import com.techevents.security.auth.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class InscribedUserService {

    private final IEventRepository eventRepository;
    private final AuthenticationService authenticationService;
    private final IInscribedUserRepository inscribedUserRepository;
    private final AuthFacade authFacade;

    public InscribedUserService(IEventRepository eventRepository, AuthenticationService authenticationService, IInscribedUserRepository inscribedUserRepository, AuthFacade authFacade) {
        this.eventRepository = eventRepository;
        this.authenticationService = authenticationService;
        this.inscribedUserRepository = inscribedUserRepository;
        this.authFacade = authFacade;
    }

    public void inscribedEvent(Long eventId){
        var event = eventRepository.findById(eventId).orElseThrow(() ->new RuntimeException("event does not exist"));
        var auth = authFacade.getAuthUser();
        var inscribedUser =  new InscribedUser(auth, event);
        inscribedUserRepository.save(inscribedUser);

    }

}
