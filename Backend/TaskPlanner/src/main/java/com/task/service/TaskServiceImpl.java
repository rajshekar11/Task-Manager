package com.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.task.entity.Task;
import com.task.entity.User;
import com.task.exception.TaskException;
import com.task.exception.UserException;
import com.task.repository.TaskRepository;
import com.task.repository.UserRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository trep;
	
	@Autowired
	private UserRepository urep;

	@Override
	public Task addAnewTask(Task task) throws TaskException {
		return trep.save(task);
	}

	@Override
	public Task getTaskById(Integer tid) throws TaskException {
		Optional<Task> opt=trep.findById(tid);
		if(opt.isPresent()) {
			Task t=opt.get();
			return t;
		}
		throw new TaskException("There are no task by id: "+tid);
	}

	@Override
	public Task assignAUserToTask(Integer uid,Integer tid) throws TaskException,UserException {
		Optional<Task> opt=trep.findById(tid);
		if(opt.isEmpty()) {
			throw new TaskException("There are no task by id: "+tid);
		}
		Task t=opt.get();
		Optional<User> opt2=urep.findById(uid);
		if(opt2.isEmpty()) {
			throw new UserException("There are no user by id: "+uid);
		}
		User u=opt2.get();
		t.setUser(u);
		return trep.save(t);
	}

	@Override
	public Task changeStatusOfATask(Integer tid, String status) throws TaskException {
		Optional<Task> opt=trep.findById(tid);
		if(opt.isPresent()) {
			Task t=opt.get();
			t.setStatus(status);
			return trep.save(t);
		}
		throw new TaskException("There are no task by id: "+tid);
	}

	@Override
	public Task deleteATaskById(Integer tid) throws TaskException {
		Optional<Task> opt=trep.findById(tid);
		if(opt.isPresent()) {
			Task t=opt.get();
			trep.delete(t);
			return t;
		}
		throw new TaskException("There are no task by id: "+tid);
	}

	@Override
	public List<Task> getAllTasks() throws TaskException {
		List<Task> li=trep.findAll();
		if(li.size()==0) {
			throw new TaskException("There are no tasks");
		}
		return li;
	}

}
