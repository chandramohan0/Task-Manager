package com.chandraMohan.taskManager.entity;


import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="task_manager")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 20)
	private String task;
	@Column(length = 255)
	private String taskDescription;
	private Boolean isCompleted;
	@CreatedDate
	private Timestamp timestamp;

	public Task(Long id, String task, String taskDescription, Boolean isCompleted) {
		this.id = id;
		this.task = task;
		this.taskDescription = taskDescription;
		this.isCompleted = isCompleted;
	}
}
