package com.chandraMohan.taskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandraMohan.taskManager.dto.TaskDTO;
import com.chandraMohan.taskManager.entity.Task;
import com.chandraMohan.taskManager.exception.TaskNotFound;
import com.chandraMohan.taskManager.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	public Task getTaskById(Long id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id)
				.orElseThrow(() -> new TaskNotFound("Task Not found for id: " + id));
	}

	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	public String addTask(TaskDTO task) {
		// TODO Auto-generated method stub
		Task newTask = new Task();
		newTask.setTask(task.getTask());
		newTask.setTaskDescription(task.getTaskDescription());
		newTask.setIsCompleted(false);
		taskRepository.save(newTask);
		return "Your task has been added";
	}

	public String updateTask(Long id, TaskDTO task) {
		// TODO Auto-generated method stub
		Task existingTask = taskRepository.findById(id)
		        .orElseThrow(() -> new TaskNotFound("Task with id " + id + " not found"));
		
	    if (task.getTaskDescription() != null && !task.getTaskDescription().isEmpty()) {
	        existingTask.setTaskDescription(task.getTaskDescription());
	    }

	    if (task.getIsCompleted() != null) {
	        existingTask.setIsCompleted(task.getIsCompleted());
	    }
	    
		taskRepository.save(existingTask);
		return "Your task has been updated";
	}

	public String deleteTaskById(Long id) {
		// TODO Auto-generated method stub
		Task task = getTaskById(id);
		taskRepository.delete(task);
		return "Your task has been updated";
	}

}
