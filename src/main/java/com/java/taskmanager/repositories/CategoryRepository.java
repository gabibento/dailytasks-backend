package com.java.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.taskmanager.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
