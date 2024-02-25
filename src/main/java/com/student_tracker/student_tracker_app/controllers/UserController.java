package com.student_tracker.student_tracker_app.controllers;

// import java.util.ArrayList;
import java.util.List;
import java.util.Map;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.student_tracker.student_tracker_app.models.User;
import com.student_tracker.student_tracker_app.models.UserRepository;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class UserController {
    @Autowired
    private UserRepository studentRepo;


    //Endpoint to display all the students 
    @GetMapping("/students/view")
    public String getAllStudents(Model model) {    
        //Get all the users from the database in order of uid
        List<User> students = studentRepo.findAll(Sort.by(Sort.Direction.ASC, "uid"));
        // call database here
        model.addAttribute("us", students);
        return "students/showAll";
    }

    //Endpoint to add new student
    @PostMapping("/students/add")
    public String addStudent(@RequestParam Map<String,String>newuser,HttpServletResponse response) {
        System.out.println("Add user");
        String newName = newuser.get("name");
        int newWeight = Integer.parseInt(newuser.get("weight"));
        int newHeight = Integer.parseInt(newuser.get("height"));
        String newHairColour = newuser.get("hairColour").toLowerCase(); 
        Double newGpa = Double.parseDouble(newuser.get("gpa") );  
        studentRepo.save(new User(newName,newWeight,newHeight,newHairColour,newGpa)); 
        response.setStatus(201);
        return "students/addedUser";
    }

    //Endpoint to update an existing student
    @PostMapping("/students/updated/{uid}")
    public String updateStudent(@PathVariable String uid, @RequestParam Map<String,String>updateStudent) {
        int id = Integer.parseInt(uid);
        // Find student by id from the database
        List<User> students = studentRepo.findByUid(id);

        System.out.println("Update student");

        if (students.size()>0) {
            for (User student : students) {
                student.setName(updateStudent.get("name"));
                student.setHeight(Integer.parseInt(updateStudent.get("height")));
                student.setWeight(Integer.parseInt(updateStudent.get("weight")));
                student.setHair_colour(updateStudent.get("hairColour").toLowerCase());
                student.setGpa(Double.parseDouble(updateStudent.get("gpa")));
                //Save the updated student to the database
                studentRepo.save(student);
            }
           
        }
        else{
            return "error";
        }
        return "students/updatedStudent";
    }

    @GetMapping("/students/update/{uid}")
    public String getStudentId(@PathVariable Integer uid, Model model) {
        System.out.println("Updating student");
        List<User>student = studentRepo.findByUid(uid);
        model.addAttribute("us",student);
        return "students/updateStudent";
    }

    @GetMapping("/students/delete/{uid}")
    public String deleteStudent(@PathVariable Integer uid) {
        studentRepo.deleteById(uid);
        return "students/deletedStudent";
    }
}
