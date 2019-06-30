package com.cts.projectmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.projectmanager.entity.*;
import com.cts.projectmanager.service.*;

@CrossOrigin
@Controller
@RequestMapping(path="/parenttask")
public class ParentTaskController {

	@Autowired
	private ParentTaskService parentTaskService;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<ParentTaskEntity> getAllParentTasks() {
		return parentTaskService.getAllParentTasks();
	}
	
	@PostMapping(path="/add")
	public @ResponseBody ParentTaskEntity addNew (@RequestBody String task) {
		return parentTaskService.addNew(task);
	}

}
