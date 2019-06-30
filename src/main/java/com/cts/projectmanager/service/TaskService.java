package com.cts.projectmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.projectmanager.entity.*;
import com.cts.projectmanager.dao.*;
import com.cts.projectmanager.repository.*;


@Service
public class TaskService {
	
	@Autowired 
	private TaskRepository taskRepo;
	
	@Autowired
	private ParentTaskRepository ptRepo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public String addNewTask(TaskDao taskDao) {
		if(taskDao.isParentTask()){
			ParentTaskEntity pTask = new ParentTaskEntity();
			pTask.setParentTask(taskDao.getTaskName());
			ptRepo.save(pTask);
		}else{
			TaskEntity taskEntity = new TaskEntity();
//			taskEntity.setParentId(taskDao.getParentTaskId());
			taskEntity.setProjectId(taskDao.getProjectId());
			taskEntity.setTask(taskDao.getTaskName());
			taskEntity.setStartDate(taskDao.getStartDate());
			taskEntity.setEndDate(taskDao.getEndDate());
			taskEntity.setPriority(taskDao.getPriority());
			taskEntity.setUserId(taskDao.getUserId());	
			taskEntity.setStatus("STARTED");
			taskRepo.save(taskEntity);
		}
		
		return "Task Added";
	}
	
	
	public List<TaskDao> getAllTasks() {
		List<TaskDao> taskObjList = new ArrayList<>();
		List<TaskEntity> taskList =  (List<TaskEntity>) taskRepo.findAll();
		for(TaskEntity t: taskList){
			TaskDao obj = new TaskDao();
			obj.setTaskId(t.getTaskId());
//			obj.setParentTaskId(t.getParentId());
			obj.setProjectId(t.getProjectId());
			obj.setTaskName(t.getTask());
			obj.setStartDate(t.getStartDate());
			obj.setEndDate(t.getEndDate());
			obj.setPriority(t.getPriority());
			obj.setStatus(t.getStatus());
			obj.setUserId(t.getUserId());
//			if(t.getParentId() != null){
//				ParentTaskEntity pTask = ptRepo.findOne(t.getParentId());
//				if(pTask != null){
//					obj.setParentTaskName(pTask.getParentTask());
//				}
//			}
			if(t.getProjectId() != null){
				ProjectEntity p= projectRepo.findOne(t.getProjectId());
				if(p != null){
					obj.setProjectName(p.getProject());
				}	
			}
			if(t.getUserId() != null){
				UserEntity u = userRepo.findOne(t.getUserId());
				if(u != null){
					obj.setUserName(u.getFirstName());
				}
			}
			
			taskObjList.add(obj);
			
		}
		
		return taskObjList;
	}
	
	

	public TaskEntity updateTask(TaskDao task) {
		TaskEntity	t = taskRepo.findOne(task.getTaskId());
//		t.setParentId(task.getParentTaskId());
		t.setProjectId(task.getProjectId());
		t.setTask(task.getTaskName());
		t.setStartDate(task.getStartDate());
		t.setEndDate(task.getEndDate());
		t.setPriority(task.getPriority());
	    t.setStatus(task.getStatus());     
		return taskRepo.save(t);
	}


	public Iterable<TaskDao> getTasksByProject(Integer id) {
		 List<TaskDao> taskObjList = new ArrayList<>();
			List<TaskEntity> taskList = taskRepo.findAllByProjectId(id);
			for(TaskEntity t: taskList){
				TaskDao obj = new TaskDao();
				obj.setTaskId(t.getTaskId());
//				obj.setParentTaskId(t.getParentId());
				obj.setProjectId(t.getProjectId());
				obj.setTaskName(t.getTask());
				obj.setStartDate(t.getStartDate());
				obj.setEndDate(t.getEndDate());
				obj.setPriority(t.getPriority());
				obj.setStatus(t.getStatus());
				obj.setUserId(t.getUserId());
//				if(t.getParentId() != null){
//					ParentTaskEntity pTask = ptRepo.findOne(t.getParentId());
//					if(pTask != null){
//						obj.setParentTaskName(pTask.getParentTask());
//					}
//				}
				if(t.getProjectId() != null){
					ProjectEntity p = projectRepo.findOne(t.getProjectId());
					if(p != null){
						obj.setProjectName(p.getProject());
					}	
				}
				if(t.getUserId() != null){
					UserEntity u = userRepo.findOne(t.getUserId());
					if(u != null){
						obj.setUserName(u.getFirstName());
					}
				}
				
				taskObjList.add(obj);
				
			}
			return taskObjList;
	}
	


}
