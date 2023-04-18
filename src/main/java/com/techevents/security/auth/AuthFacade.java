package com.techevents.security.auth;


import com.techevents.security.user.User;
import com.techevents.security.user.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthFacade {
    private final UserRepository userRepository;

    public AuthFacade(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User getAuthUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return this.userRepository.findByEmail(auth.getName()).get();


    }
}
