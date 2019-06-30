package com.cts.projectmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanager.dao.ProjectDao;
import com.cts.projectmanager.service.ProjectService;

@CrossOrigin
@RestController
@RequestMapping(path="/project")
public class ProjectManagerController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("/")
	public String welcome() {
		return "Hello from Project Management App!!!!";
	}	
	
	@PostMapping()
	public @ResponseBody ProjectDao addProject(@RequestBody ProjectDao project){
		return projectService.addProject(project);
	}
	
	@PutMapping
	public @ResponseBody ProjectDao updateProject(@RequestBody ProjectDao project){
		
	return projectService.updateProject(project);
	}
	
	@GetMapping(path="/all")
	public @ResponseBody List<ProjectDao> getAllProject() {
		
		return projectService.getAllProject();
	}

}
