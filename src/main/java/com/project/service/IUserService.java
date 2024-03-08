package com.project.service;

import com.project.entryDtos.UserEntryDTO;
import com.project.models.UserDetails;

public interface IUserService {

	String addUser(UserEntryDTO user);
	
	UserDetails getUserById(int id);
	
	Iterable<UserDetails> getAllUser();
}
