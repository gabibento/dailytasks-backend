package com.java.taskmanager.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java.taskmanager.entities.User;
import com.java.taskmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.taskmanager.dtos.TaskDTO;
import com.java.taskmanager.entities.Category;
import com.java.taskmanager.entities.Priority;
import com.java.taskmanager.entities.Task;
import com.java.taskmanager.repositories.CategoryRepository;
import com.java.taskmanager.repositories.PriorityRepository;
import com.java.taskmanager.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired 
    private PriorityRepository priorityRepository;

    @Autowired
    private UserRepository userRepository;

    public TaskDTO insert(TaskDTO dto) {
        Task task = new Task();

        task.setTitle(dto.getTitle());
        task.setCompleted(dto.isCompleted());


        if (dto.getDate() != null) task.setDate(dto.getDate());

        Optional<Category> categoryOpt = categoryRepository.findById(dto.getCategoryId());
        if (categoryOpt.isPresent()) task.setCategory(categoryOpt.get());
        else throw new RuntimeException("Category not found");

        Optional<Priority> priorityOpt = priorityRepository.findById(dto.getPriorityId());
        if (priorityOpt.isPresent()) task.setPriority(priorityOpt.get());
        else throw new RuntimeException("Priority not found");


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserDetails user = userRepository.findByUsername(username);
        if (user == null) throw new RuntimeException("User not found");
        task.setUser((User) user);

        task = taskRepository.save(task);
        return new TaskDTO(task);
    }


    @Transactional(readOnly = true)
    public List<TaskDTO> getUserTasks(User user) {
        List<Task> tasks = taskRepository.findByUser(user, Sort.by(Sort.Order.asc("priority"))); // Ordenar por prioridade
        return tasks.stream().map(TaskDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }


    public TaskDTO update(Task task) {
        Task entity = taskRepository.save(task);
        return new TaskDTO(entity);
    }
    public TaskDTO update(Long id, TaskDTO dto) {
        // Verificar se a tarefa existe
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new RuntimeException("Task not found");
        }

        Task task = optionalTask.get();
        
        // Atualizar os campos da tarefa com os dados fornecidos no DTO
        task.setTitle(dto.getTitle());
        
        if (dto.getDate() != null) {
            task.setDate(dto.getDate());
        }

        // Atualizar categoria
        Optional<Category> categoryOpt = categoryRepository.findById(dto.getCategoryId());
        if (categoryOpt.isPresent()) {
            task.setCategory(categoryOpt.get());
        } else {
            throw new RuntimeException("Category not found");
        }

        // Atualizar prioridade
        Optional<Priority> priorityOpt = priorityRepository.findById(dto.getPriorityId());
        if (priorityOpt.isPresent()) {
            task.setPriority(priorityOpt.get());
        } else {
            throw new RuntimeException("Priority not found");
        }

        // Salvar as alterações
        task = taskRepository.save(task);
        return new TaskDTO(task);
    }

    @Transactional
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
