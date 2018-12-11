package com.elu.canoo.library.controllers;

import com.elu.canoo.library.dtos.UserDto;
import com.elu.canoo.library.models.CanooUser;
import com.elu.canoo.library.repositories.UserRepository;
import com.elu.canoo.library.services.MongoUserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final MongoUserDetailsService userDetailsService;
    private final UserRepository userRepository;

    public UserController(MongoUserDetailsService userDetailsService, UserRepository userRepository) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    @RequestMapping("/login")
    public CanooUser login(@RequestBody UserDto user) {
        if (new BCryptPasswordEncoder().matches(user.getPassword(),
                userDetailsService.loadUserByUsername(user.getUsername()).getPassword())) {
            return userRepository.findByUsername(user.getUsername());
        }
        return null;
    }
}
