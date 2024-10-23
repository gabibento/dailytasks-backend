package com.java.taskmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.taskmanager.entities.Category;
import com.java.taskmanager.repositories.CategoryRepository;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
	
	@Autowired
	private CategoryRepository repository;
	
	@GetMapping
	public List<Category> findAll(){
		return repository.findAll();
	}
}
