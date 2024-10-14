package com.chandraMohan.taskManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidTaskBodyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public InvalidTaskBodyException(String message) {
        super(message);
    }
}
