package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.entity.Sprint;
import com.task.entity.Task;
import com.task.exception.SprintException;
import com.task.service.SprintService;

@RestController
public class SprintController {

	@Autowired
	private SprintService sser;
	
	@PostMapping("/sprint")
	public ResponseEntity<Sprint> addASprint(@RequestBody Sprint sp) throws SprintException{
		Sprint s=sser.addASprint(sp);
		return new ResponseEntity<Sprint>(s,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/sprint/{sprintName}")
	public ResponseEntity<List<Task>> getAllTasksInASprint(@PathVariable("sprintName") String sprintName) throws SprintException{
		List<Task> s=sser.getAllTasksInASprint(sprintName);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	@GetMapping("/allsprint")
	public ResponseEntity<List<Sprint>> getAllSprint() throws SprintException{
		List<Sprint> s=sser.getAllSprint();
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
}
