package main.service;

import main.doma.repository.UserRepository;
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

    public List<User> getUserByIds(List<Long> ids){
        return userRepository.findByIds(ids);
    }
}
