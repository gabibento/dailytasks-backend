package com.java.taskmanager.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.taskmanager.dtos.TaskDTO;
import com.java.taskmanager.entities.Task;
import com.java.taskmanager.services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@PostMapping
	public TaskDTO insert(@RequestBody TaskDTO task) {
		return service.insert(task);
	}
	@GetMapping
	public List<TaskDTO> findAll() {
		return service.findAll();
	}
	@GetMapping("/{id}")
	public Optional<Task> findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PatchMapping("/{id}")
    public ResponseEntity<TaskDTO> toggleTaskCompleted(@PathVariable Long id) {
		Optional<Task> optionalTask = service.findById(id);
		
		if(optionalTask.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Task task = optionalTask.get();
		task.setCompleted(!task.isCompleted());
		
		
		TaskDTO updatedTask = service.update(task);
        return ResponseEntity.ok(updatedTask);
	}
	  @PutMapping("/{id}")
	    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
	        try {
	            TaskDTO updatedTask = service.update(id, taskDTO);
	            return ResponseEntity.ok(updatedTask);
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build(); // Task não encontrada
	        }
	    }
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}
	
	
	
}
