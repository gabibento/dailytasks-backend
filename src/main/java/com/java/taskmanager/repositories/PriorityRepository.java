package com.java.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.taskmanager.entities.Priority;

public interface PriorityRepository extends JpaRepository<Priority, Long>{

}
