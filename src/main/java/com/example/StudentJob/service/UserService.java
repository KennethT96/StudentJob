package com.example.StudentJob.service;

import com.example.StudentJob.entity.Users;
import com.example.StudentJob.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public String loginUser(@ModelAttribute("user") Users users){
        Users userdata = repository.findByEmail(users.getEmail());
        if(userdata != null){
            if(users.getPassword().equals(userdata.getPassword())){
                return "index";
            }else{
                return "error";
            }
        }else {
            return "error";
        }
    }
}
