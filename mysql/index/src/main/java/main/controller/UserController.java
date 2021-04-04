package main.controller;

//import main.service.UserService;

import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public Object getUser() {
        return userService.getUser();
    }

    @RequestMapping("/{userId}")
    public Object getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

}
