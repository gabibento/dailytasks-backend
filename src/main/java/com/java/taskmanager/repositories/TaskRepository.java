package com.java.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.taskmanager.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
