package com.chandraMohan.taskManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
	
	private String task;
	private String taskDescription;
	private Boolean isCompleted;

}
