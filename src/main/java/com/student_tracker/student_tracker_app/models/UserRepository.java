package com.student_tracker.student_tracker_app.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByName(String name);
    List<User> findByHeightAndWeight(int height, int weight);
}
