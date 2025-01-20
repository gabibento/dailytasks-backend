package com.java.taskmanager.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	private boolean completed;
	
	private LocalDate date;
	
	@ManyToOne
    @JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
    @JoinColumn(name = "priority_id")
	private Priority priority;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Task() {
	
	}
	
	public Task(Long id, String title, boolean completed, Category category, LocalDate date, Priority priority, User user) {
		super();
		this.id = id;
		this.title = title;
		this.completed = completed;
		this.category = category;
		this.date = date;
		this.priority = priority;
		this.user = user;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
