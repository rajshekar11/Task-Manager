package com.task.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(TaskException.class)
	public ResponseEntity<MyError> taskExceptionHandler(TaskException te,WebRequest wreq){
		MyError me=new MyError();
		me.setTimestamp(LocalDateTime.now());
		me.setMessage(te.getMessage());
		me.setDescription(wreq.getDescription(false));
		return new ResponseEntity<>(me,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyError> userExceptionHandler(UserException te,WebRequest wreq){
		MyError me=new MyError();
		me.setTimestamp(LocalDateTime.now());
		me.setMessage(te.getMessage());
		me.setDescription(wreq.getDescription(false));
		return new ResponseEntity<>(me,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SprintException.class)
	public ResponseEntity<MyError> sprintExceptionHandler(SprintException te,WebRequest wreq){
		MyError me=new MyError();
		me.setTimestamp(LocalDateTime.now());
		me.setMessage(te.getMessage());
		me.setDescription(wreq.getDescription(false));
		return new ResponseEntity<>(me,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> globalExceptionHandler(Exception be,WebRequest wr){
		MyError me=new MyError();
		me.setMessage(be.getMessage());
		me.setTimestamp(LocalDateTime.now());
		me.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyError>(me,HttpStatus.BAD_REQUEST);
	}
}
