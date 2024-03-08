package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entryDtos.ShowEntryDTO;
import com.project.service.IShowService;

@RestController
@RequestMapping("/show")
public class ShowController {
	
	@Autowired
	private IShowService serv;

	
	@PostMapping("/add")
	public ResponseEntity<String> addShow(@RequestBody ShowEntryDTO show){
		String msg =  serv.addShow(show);
		
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
//	public 
}
