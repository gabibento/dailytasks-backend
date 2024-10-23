package com.java.taskmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.taskmanager.entities.Priority;
import com.java.taskmanager.repositories.PriorityRepository;

@RestController
@RequestMapping(value = "/priorities")
public class PriorityController {
	
	@Autowired
	private PriorityRepository repository;
	
	@GetMapping
	public List<Priority> findAll(){
		return repository.findAll();
	}

}
