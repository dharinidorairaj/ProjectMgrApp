package com.cts.projectmanager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.projectmanager.entity.*;


import com.cts.projectmanager.service.*;


@CrossOrigin
@Controller   
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired 
	private UserService userService;

	@PostMapping(path="/add")
	public @ResponseBody UserEntity addNewUser (@RequestBody UserEntity user) {

		return userService.addNewUser(user);
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<UserEntity> getAllUsers() {
		return userService.findAll();
	}
	
	@PutMapping(path="/update")
	public @ResponseBody UserEntity updateUser(@RequestBody UserEntity user){

		return userService.updateUser(user);
	}
	
	
}

