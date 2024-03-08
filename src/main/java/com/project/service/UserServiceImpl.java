package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IUserDao;
import com.project.entryDtos.UserEntryDTO;
import com.project.exception.UserNotFoundException;
import com.project.models.UserDetails;


@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	
	@Override
	public String addUser(UserEntryDTO user) {
		// TODO Auto-generated method stub
		UserDetails userDetails = UserDetails.builder().name(user.getName())
				.age(user.getAge()).address(user.getAddress()).email(user.getEmail())
				.mobileNumber(user.getMobileNumber()).build();
		
		return userDao.save(userDetails).getId() +" saved successfully";
	}

	@Override
	public UserDetails getUserById(int id) {
		// TODO Auto-generated method stub
		Optional<UserDetails> byId = userDao.findById(id);
		if(byId.isPresent()) {
			
			return byId.get();
		}
		throw new UserNotFoundException(id+" user not found");
	}

	@Override
	public Iterable<UserDetails> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

}
