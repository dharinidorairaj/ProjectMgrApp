package com.cts.projectmanager.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.cts.projectmanager.entity.*;
import com.cts.projectmanager.dao.*;
import com.cts.projectmanager.service.*;
@CrossOrigin
@Controller
@RequestMapping(path="/task")
public class TaskController {
	
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewTask (@RequestBody TaskDao task) {

		return taskService.addNewTask(task);
	}

	@GetMapping(path="/all")
	public @ResponseBody List<TaskDao> getAllTasks() {
		return taskService.getAllTasks();
	}
	
	@PutMapping(path="/update")
	public @ResponseBody TaskEntity updateTask(@RequestBody TaskDao task){
		
		return taskService.updateTask(task);
	}
	
	
	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public @ResponseBody Iterable<TaskDao> getTasksByProject(@PathVariable("id") Integer id){
 
		return taskService.getTasksByProject(id);
		
	}

}
