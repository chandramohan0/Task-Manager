package com.chandraMohan.taskManager.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.chandraMohan.taskManager.dto.TaskDTO;
import com.chandraMohan.taskManager.entity.Task;
import com.chandraMohan.taskManager.service.TaskService;
import org.springframework.validation.BindingResult;

class TaskControllerTest {

    @Mock
    private TaskService taskService;

    @Mock
    private BindingResult bindingResult;

    @InjectMocks
    private TaskController taskController;


    private Task sampleTask;
    private TaskDTO sampleTaskDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        sampleTask = new Task();
        sampleTask.setId(1L);
        sampleTask.setTask("Test Task");
        sampleTask.setTaskDescription("This is a test task.");
        sampleTask.setIsCompleted(false);

        sampleTaskDTO = new TaskDTO();
        sampleTaskDTO.setTask("Test Task");
        sampleTaskDTO.setTaskDescription("This is a test task.");
        sampleTaskDTO.setIsCompleted(false);
    }

    @Test
    void testGetTaskById() {
    	
        when(taskService.getTaskById(1L)).thenReturn(sampleTask);

        Task result = taskController.getTaskById(1L);

        assertNotNull(result);
        assertEquals(sampleTask.getId(), result.getId());
        assertEquals(sampleTask.getTask(), result.getTask());
        assertEquals(sampleTask.getTaskDescription(), result.getTaskDescription());
        assertEquals(sampleTask.getIsCompleted(), result.getIsCompleted());
        verify(taskService, times(1)).getTaskById(1L);
    }

    @Test
    void testGetAllTasks() {

        List<Task> tasks = Arrays.asList(sampleTask);
        when(taskService.getAllTasks()).thenReturn(tasks);

        List<Task> result = taskController.getAllTasks();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(taskService, times(1)).getAllTasks();
    }

    @Test
    void testAddTask() {
        when(bindingResult.hasErrors()).thenReturn(false);
        when(taskService.addTask(any(TaskDTO.class))).thenReturn("Task added successfully");

        String result = taskController.addTask(sampleTaskDTO, bindingResult);

        assertEquals("Task added successfully", result);
        verify(taskService, times(1)).addTask(any(TaskDTO.class));
    }

    @Test
    void testUpdateTask() {
        when(bindingResult.hasErrors()).thenReturn(false);
        when(taskService.updateTask(eq(1L), any(TaskDTO.class))).thenReturn("Task updated successfully");

        String result = taskController.updateTask(1L, sampleTaskDTO, bindingResult);

        assertEquals("Task updated successfully", result);
        verify(taskService, times(1)).updateTask(eq(1L), any(TaskDTO.class));
    }

    @Test
    void testDeleteTaskById() {

        when(taskService.deleteTaskById(1L)).thenReturn("Task deleted successfully");

        String result = taskController.deleteTaskById(1L);

        assertEquals("Task deleted successfully", result);
        verify(taskService, times(1)).deleteTaskById(1L);
    }
}
