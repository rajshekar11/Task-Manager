package com.task.service;

import java.util.List;

import com.task.entity.Task;
import com.task.exception.TaskException;
import com.task.exception.UserException;

public interface TaskService {

	public Task addAnewTask(Task task) throws TaskException;
	
	public Task getTaskById(Integer tid) throws TaskException;
	
	public Task assignAUserToTask(Integer uid,Integer tid) throws TaskException,UserException;
	
	public Task changeStatusOfATask(Integer uid,String status) throws TaskException;
	
	public Task deleteATaskById(Integer uid) throws TaskException;
	
	public List<Task> getAllTasks() throws TaskException;
}
