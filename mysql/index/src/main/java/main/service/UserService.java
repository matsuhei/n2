package main.service;

import main.doma.UserRepository;
import main.doma.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUser(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id);
    }
}
