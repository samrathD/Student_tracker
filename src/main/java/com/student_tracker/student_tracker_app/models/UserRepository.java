package com.student_tracker.student_tracker_app.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByAge(int age);
    List<User> findByNameAndPassword(String name, String password);

}
