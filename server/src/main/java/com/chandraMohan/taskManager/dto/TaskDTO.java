package com.chandraMohan.taskManager.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
	@Size(min = 3, max = 20)
	private String task;
	@Size(min = 5,max = 255)
	private String taskDescription;
	private Boolean isCompleted;

}
