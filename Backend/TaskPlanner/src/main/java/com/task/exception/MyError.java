package com.task.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyError {

	private LocalDateTime timestamp;
	private String message;
	private String description;
}
