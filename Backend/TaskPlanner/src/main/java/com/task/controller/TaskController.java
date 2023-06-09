package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.entity.Task;
import com.task.exception.TaskException;
import com.task.exception.UserException;
import com.task.service.TaskService;

import jakarta.validation.Valid;

@RestController
public class TaskController {

	@Autowired
	private TaskService tser;
	
	@PostMapping("/task")
	public ResponseEntity<Task> addAnewTask(@Valid @RequestBody Task task) throws TaskException{
		Task t=tser.addAnewTask(task);
		return new ResponseEntity<Task>(t,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/task/{tid}")
	public ResponseEntity<Task> getTaskById(@PathVariable("tid") Integer tid) throws TaskException{
		Task t=tser.getTaskById(tid);
		return new ResponseEntity<Task>(t,HttpStatus.OK);
	}
	
	@PutMapping("/task/{uid}")
	public ResponseEntity<Task> assignAUserToTask(@PathVariable("uid") Integer uid,@RequestParam Integer tid) throws TaskException,UserException{
		Task t=tser.assignAUserToTask(uid, tid);
		return new ResponseEntity<Task>(t,HttpStatus.OK);
	}
	@PutMapping("/taskstatus/{uid}")
	public ResponseEntity<Task> changeStatusOfATask(@PathVariable("uid") Integer uid,@RequestParam String status) throws TaskException{
		Task t=tser.changeStatusOfATask(uid, status);
		return new ResponseEntity<Task>(t,HttpStatus.OK);
	}
	
	@DeleteMapping("/task/{uid}")
	public ResponseEntity<Task> deleteATaskById(@PathVariable("uid") Integer uid) throws TaskException{
		Task t=tser.deleteATaskById(uid);
		return new ResponseEntity<Task>(t,HttpStatus.OK);
	}
	
	@GetMapping("/alltask")
	public ResponseEntity<List<Task>> getAllTasks() throws TaskException{
		List<Task> t=tser.getAllTasks();
		return new ResponseEntity<>(t,HttpStatus.OK);
	}
}
