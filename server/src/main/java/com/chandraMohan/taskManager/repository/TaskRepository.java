package com.chandraMohan.taskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandraMohan.taskManager.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{


}
