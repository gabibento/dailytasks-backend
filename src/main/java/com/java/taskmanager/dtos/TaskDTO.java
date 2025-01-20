package com.java.taskmanager.dtos;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.java.taskmanager.entities.Task;

public class TaskDTO {
	private Long id;
	private String title;
	private boolean completed;
	private Long userId;
	private Long categoryId;
	private String categoryName;
	private Long priorityId;
	private String priorityName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	public TaskDTO() {

	}
	
	public TaskDTO(Long id, String title, boolean completed, Long userId, Long categoryId, String categoryName, Long priorityId, String priorityName, LocalDate date) {
		this.id = id;
		this.title = title;
		this.completed = completed;
		this.userId = userId;
		this.categoryId = categoryId;
		this.categoryName= categoryName;
		this.priorityId = priorityId;
		this.priorityName = priorityName;
		this.date = date;
	}

	public TaskDTO(Task task) {
		id = task.getId();
		title = task.getTitle();
		completed = task.isCompleted();
		userId = task.getUser().getId();
		categoryId = task.getCategory().getId();
		categoryName = task.getCategory().getName();
		priorityId = task.getPriority().getId();
		priorityName = task.getPriority().getName();
		date = task.getDate() != null ? task.getDate() : null;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	

	public Long getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(Long priorityId) {
		this.priorityId = priorityId;
	}

	public String getPriorityName() {
		return priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
