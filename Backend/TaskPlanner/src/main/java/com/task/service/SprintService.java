package com.task.service;

import java.util.List;

import com.task.entity.Sprint;
import com.task.entity.Task;
import com.task.exception.SprintException;

public interface SprintService {

	public Sprint addASprint(Sprint sp) throws SprintException;
	
	public List<Task> getAllTasksInASprint(String sprintName) throws SprintException;
	
	public List<Sprint> getAllSprint() throws SprintException;
}
