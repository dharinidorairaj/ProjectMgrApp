package com.cts.projectmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.projectmanager.dao.ProjectDao;
import com.cts.projectmanager.entity.ProjectEntity;
import com.cts.projectmanager.entity.UserEntity;
import com.cts.projectmanager.repository.ProjectRepository;
import com.cts.projectmanager.repository.TaskRepository;
import com.cts.projectmanager.repository.UserRepository;

@Service
public class ProjectService {
	@Autowired 
	private ProjectRepository projectRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 
	TaskRepository taskRepo;
	
	public ProjectDao addProject(ProjectDao p) {
		ProjectEntity project = new ProjectEntity();
		project.setProject(p.getProjectName());
		project.setStartDate(p.getStartDate());
		project.setEndDate(p.getEndDate());
		project.setPriority(p.getPriority());
		project.setUserId(p.getUserId());
		projectRepository.save(project);
		p.setCompletedTaskNumber(0);
		p.setTaskNumber(0);
		return p;
	}
	
	public ProjectDao updateProject(ProjectDao p) {
		ProjectEntity project = projectRepository.findOne(p.getProjectId());
		if(project!= null){
			project.setProject(p.getProjectName());
			project.setStartDate(p.getStartDate());
			project.setEndDate(p.getEndDate());
			project.setPriority(p.getPriority());
			project.setUserId(p.getUserId());
			projectRepository.save(project);
			return p;
		}else{
			return null;
		}	
	}
	
	public List<ProjectDao> getAllProject() {
		 Iterable<ProjectEntity> projectList =  projectRepository.findAll();
		 List<ProjectDao> projectResponseList = new ArrayList<>();
		 for(ProjectEntity project: projectList){
			 ProjectDao  p = new ProjectDao();
			 p.setProjectId(project.getProjectId());
			 p.setProjectName(project.getProject());
			 p.setStartDate(project.getStartDate());
			 p.setEndDate(project.getEndDate());
			 p.setPriority(project.getPriority());
			 p.setTaskNumber(taskRepo.findAllByProjectId(project.getProjectId()).size());
			 p.setCompletedTaskNumber(taskRepo.findAllByProjectIdAndStatus(project.getProjectId(), "COMPLETED").size());
			 p.setUserId(project.getUserId());
			 if(project.getUserId() != null){
				 UserEntity  u = userRepository.findOne(project.getUserId());
				 if( u != null){
					 p.setManager(u.getFirstName());
				 }
			 }
			 
			 projectResponseList.add(p);
		 }
		
		return projectResponseList;
	}

}
