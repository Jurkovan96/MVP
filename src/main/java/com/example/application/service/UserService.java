package com.example.application.service;

import com.example.application.model.User;
import com.example.application.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void addDummyUsers() {
        if (userRepository.findAll().size() == 0)
            for (int i = 0; i < 7; i++) {
                userRepository.save(new User("Username" + i, "userEmail" +
                        i + "@emaildom.com", "Summary: user" + i));
            }
    }

    public User getUserByName(String userName) {
        return userRepository.findAllByUserName(userName);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
