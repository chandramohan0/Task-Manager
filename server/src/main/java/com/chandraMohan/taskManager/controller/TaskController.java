package com.chandraMohan.taskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chandraMohan.taskManager.dto.TaskDTO;
import com.chandraMohan.taskManager.entity.Task;
import com.chandraMohan.taskManager.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/task")
@Tag(name="Task APIs",  description="Read, Create, Update & Delete Tasks")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("/id/{id}")
	@Operation(summary = "Get Task By Id")
	@ResponseStatus(HttpStatus.OK)
	public Task getTaskById(@PathVariable Long id) {
		return taskService.getTaskById(id);
	}
	
	@GetMapping("/all")
	@Operation(summary = "Get All Tasks")
	@ResponseStatus(HttpStatus.OK)
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
	}
	
	@PostMapping("/add")
	@Operation(summary = "Add Task")
	@ResponseStatus(HttpStatus.OK)
	public String addTask(@RequestBody TaskDTO task) {
		return taskService.addTask(task);
	}
	
	@PutMapping("/update/id/{id}")
	@Operation(summary = "Update Task")
	@ResponseStatus(HttpStatus.OK)
	public String updateTask(@PathVariable Long id, @RequestBody TaskDTO task) {
		return taskService.updateTask(id, task);
	}
	
	@DeleteMapping("/delete/id/{id}")
	@Operation(summary = "Delete Task")
	@ResponseStatus(HttpStatus.OK)
	public String deleteTaskById(@PathVariable Long id) {
		return taskService.deleteTaskById(id);
	}
}
