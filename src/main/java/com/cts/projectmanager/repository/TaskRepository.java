package com.cts.projectmanager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cts.projectmanager.entity.*;

public interface TaskRepository extends CrudRepository<TaskEntity,Integer>{

	List<TaskEntity> findAllByProjectId(Integer id);
		
	List<TaskEntity> findAllByProjectIdAndStatus(Integer id, String status);

//	TaskEntity findOne(Integer taskId);
	
}
