package com.example.StudentJob.controller;


import com.example.StudentJob.entity.Users;
import com.example.StudentJob.repository.UserRepository;
import com.example.StudentJob.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String login(Model model){
        Users user = new Users();
        model.addAttribute("user", user);
        return "login";
    }
    @PostMapping("/userLogin")
    public String loginUser(@ModelAttribute("user")Users users){
       return userService.loginUser(users);
    }

}
