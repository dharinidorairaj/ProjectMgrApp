package com.cts.projectmanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.projectmanager.dao.*;
import com.cts.projectmanager.entity.UserEntity;
import com.cts.projectmanager.repository.*;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	


	public UserEntity addNewUser(UserEntity user) {
		UserEntity n =new UserEntity();
		n.setFirstName(user.getFirstName());
		n.setLastName(user.getLastName());
		n.setEmployeeId(user.getEmployeeId());
		return userRepo.save(n);
	}

	public Iterable<UserEntity> findAll() {
		
		return userRepo.findAll();
	}



	
	 public UserEntity updateUser(UserEntity user) {
		UserEntity n = userRepo.findOne(user.getUserId());
		n.setEmployeeId(user.getEmployeeId());
		n.setFirstName(user.getFirstName());
		n.setLastName(user.getLastName());
		return n;
	} 


}
