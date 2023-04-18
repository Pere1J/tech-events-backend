package com.techevents.service;

import com.techevents.security.user.User;
import com.techevents.security.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getByName (String name){
    return this.userRepository.getByName(name).get();
    }

}
