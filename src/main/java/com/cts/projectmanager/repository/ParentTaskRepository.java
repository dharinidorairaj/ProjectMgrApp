package com.cts.projectmanager.repository;

import org.springframework.data.repository.CrudRepository;

import com.cts.projectmanager.entity.*;

public interface ParentTaskRepository extends CrudRepository<ParentTaskEntity, Integer> {

//	ParentTaskEntity findOne(Integer parentId);

}
