package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entryDtos.UserEntryDTO;
import com.project.models.UserDetails;
import com.project.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private IUserService serv;

	
	@PostMapping("/addUser")
	public String addUser(@RequestBody UserEntryDTO user) {
		return serv.addUser(user);
	}
	
	@GetMapping("/getUser/{id}")
	public UserDetails getUserById(@PathVariable(value="id") int id) {
		return serv.getUserById(id);
	}
	
	@GetMapping("getAllUser")
	public Iterable<UserDetails> getAllUser(){
		return serv.getAllUser();
	}
}
