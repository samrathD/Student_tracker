package com.student_tracker.student_tracker_app.controllers;

// import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.student_tracker.student_tracker_app.models.User;
import com.student_tracker.student_tracker_app.models.UserRepository;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    @Autowired
    private UserRepository userRepo;
     
    @GetMapping("/users/view")
    public String getAllUsers(Model model) {    
        //Get all the users from the database
        List<User> users = userRepo.findAll();//Find all is equivalent to select * 
        // call database here
        model.addAttribute("us", users);
        return "users/showAll";
    }

    @PostMapping("/users/add")
    public String adduser(@RequestParam Map<String,String>newuser,HttpServletResponse response) {
        System.out.println("Add user");
        String newName = newuser.get("name");
        int newWeight = Integer.parseInt(newuser.get("weight"));
        int newHeight = Integer.parseInt(newuser.get("height"));
        String newHairColour = newuser.get("hairColour"); 
        Double newGpa = Double.parseDouble(newuser.get("gpa") );  
        userRepo.save(new User(newName,newWeight,newHeight,newHairColour,newGpa)); 
        response.setStatus(201);
        return "users/addedUser";
    }
    
}
