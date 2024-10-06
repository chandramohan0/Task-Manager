package com.chandraMohan.taskManager.service;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.chandraMohan.taskManager.dto.TaskDTO;
import com.chandraMohan.taskManager.entity.Task;
import com.chandraMohan.taskManager.exception.TaskNotFound;
import com.chandraMohan.taskManager.repository.TaskRepository;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetTaskById_Found() {
        Long taskId = 1L;
        Task task = new Task();
        task.setId(taskId);
        task.setTask("Sample Task");
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        Task result = taskService.getTaskById(taskId);

        assertNotNull(result);
        assertEquals(taskId, result.getId());
        assertEquals("Sample Task", result.getTask());
    }

    @Test
    void testGetTaskById_NotFound() {
        Long taskId = 1L;
        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());

        assertThrows(TaskNotFound.class, () -> taskService.getTaskById(taskId));
    }

    @Test
    void testGetAllTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L, "Task 1", "Task 1 Description", false));
        tasks.add(new Task(2L, "Task 2", "Task 2 Description", true));
        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getAllTasks();

        assertEquals(2, result.size());
        assertEquals("Task 1", result.get(0).getTask());
        assertEquals("Task 2", result.get(1).getTask());
    }

    @Test
    void testAddTask() {
        TaskDTO taskDTO = new TaskDTO("New Task", "New Task Description", false);
        Task newTask = new Task();
        newTask.setTask("New Task");
        newTask.setTaskDescription("New Task Description");
        newTask.setIsCompleted(false);
        when(taskRepository.save(any(Task.class))).thenReturn(newTask);

        String result = taskService.addTask(taskDTO);

        assertEquals("Your task has been added", result);
        
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void testUpdateTask_Found() {
        Long taskId = 1L;
        TaskDTO taskDTO = new TaskDTO("Updated Task", "Updated Task Description", true);
        Task existingTask = new Task(taskId, "Old Task", "Old Task Description", false);
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(existingTask));
        when(taskRepository.save(any(Task.class))).thenReturn(existingTask);

        String result = taskService.updateTask(taskId, taskDTO);

        assertEquals("Your task has been updated", result);
        assertEquals("Updated Task Description", existingTask.getTaskDescription());
        assertTrue(existingTask.getIsCompleted());
        verify(taskRepository, times(1)).save(existingTask);
    }

    @Test
    void testUpdateTask_NotFound() {
        Long taskId = 1L;
        TaskDTO taskDTO = new TaskDTO("Updated Task", "Updated Task Description", true);
        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());

        assertThrows(TaskNotFound.class, () -> taskService.updateTask(taskId, taskDTO));
    }

    @Test
    void testDeleteTaskById_Found() {
        Long taskId = 1L;
        Task task = new Task();
        task.setId(taskId);
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        String result = taskService.deleteTaskById(taskId);

        assertEquals("Your task has been updated", result);
        verify(taskRepository, times(1)).delete(task);
    }

    @Test
    void testDeleteTaskById_NotFound() {
        Long taskId = 1L;
        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());

        assertThrows(TaskNotFound.class, () -> taskService.deleteTaskById(taskId));
    }
}
