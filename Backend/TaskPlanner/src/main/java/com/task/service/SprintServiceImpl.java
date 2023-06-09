package com.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entity.Sprint;
import com.task.entity.Task;
import com.task.exception.SprintException;
import com.task.repository.SprintRepository;

@Service
public class SprintServiceImpl implements SprintService {

	@Autowired
	private SprintRepository srep;
	
	@Override
	public Sprint addASprint(Sprint sp) throws SprintException {
		return srep.save(sp);
	}

	@Override
	public List<Task> getAllTasksInASprint(String sprintName) throws SprintException {
		Optional<Sprint> opt= srep.findBySprintName(sprintName);
		if(opt.isPresent()) {
			Sprint s=opt.get();
			List<Task> li= s.getTaskslist();
			if(li.size()==0) {
				throw new SprintException("There are no tasks in this sprint");
			}
			return li;
		}
		throw new SprintException("There are no sprint by sprintName: "+sprintName);
	}

	@Override
	public List<Sprint> getAllSprint() throws SprintException {
		List<Sprint> li= srep.findAll();
		if(li.size()==0) {
			throw new SprintException("There are no sprints");
		}
		return li;
	}

}
