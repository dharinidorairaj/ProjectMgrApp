package com.cts.projectmanager.repository;

import org.springframework.data.repository.CrudRepository;

import com.cts.projectmanager.entity.ProjectEntity;

public interface ProjectRepository extends CrudRepository<ProjectEntity,Integer>{

//	ProjectEntity findOne(Integer projectId);

}
