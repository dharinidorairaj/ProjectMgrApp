package com.cts.projectmanager.repository;


import org.springframework.data.repository.CrudRepository;

import com.cts.projectmanager.entity.*;


public interface UserRepository extends CrudRepository<UserEntity, Integer> {

//	UserEntity findOne(Integer userId);

}