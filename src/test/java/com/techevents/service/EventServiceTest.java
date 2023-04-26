package com.techevents.service;

import com.techevents.domain.models.Event;
import com.techevents.infrastructure.repositories.ICategoryRepository;
import com.techevents.infrastructure.repositories.IEventRepository;
import com.techevents.security.auth.AuthFacade;
import com.techevents.security.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class EventServiceTest {

    @Mock
    private IEventRepository eventRepository;
    @Mock
    private ICategoryRepository categoryRepository;
    @Mock
    private AuthFacade authFacade;
    private  EventService eventService;


    @BeforeEach
    void setUp(){
        openMocks(this);
        this.eventService = new EventService(eventRepository,categoryRepository,authFacade);
    }

    @Test
    void findAll_ReturnsAEventList() {
        List<Event> eventList = new ArrayList<>();
        eventList.add(new Event());


        when(authFacade.getAuthUser()).thenReturn(new User());
        when(eventRepository.findAll()).thenReturn(eventList);


        var sut = eventService.findAll();


        assertEquals(eventList.size(), sut.size());
        verify(eventRepository, times(1)).findAll();
    }
}
