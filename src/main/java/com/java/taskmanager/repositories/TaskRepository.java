package com.java.taskmanager.repositories;

import com.java.taskmanager.entities.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java.taskmanager.entities.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>{
    List<Task> findByUser(User user, Sort sort);
}
