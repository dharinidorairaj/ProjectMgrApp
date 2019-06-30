package com.cts.projectmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.projectmanager.entity.*;
import com.cts.projectmanager.repository.*;;

@Service
public class ParentTaskService {
	
	@Autowired
	private ParentTaskRepository ptRepository;
	

	public Iterable<ParentTaskEntity> getAllParentTasks() {
		return ptRepository.findAll();
	}
	
	

	public ParentTaskEntity addNew(String task) {
		ParentTaskEntity ptask = new ParentTaskEntity();
		ptask.setParentTask(task);
		return ptRepository.save(ptask);
	}
	

}
