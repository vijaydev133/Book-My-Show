package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entryDtos.TheatreEntryDTO;
import com.project.models.Theatre;
import com.project.service.ITheatreService;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

	@Autowired
	private ITheatreService ITheatreService;
	
	
	@PostMapping("/add")
	public ResponseEntity<String> addTheatre(@RequestBody TheatreEntryDTO theatreEntrDTO){
		String msg= ITheatreService.addTheatre(theatreEntrDTO);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
//	@GetMapping("/getAll")
//	public ResponseEntity<Iterable<Theatre>> getAllTheatre(){
//		Iterable<Theatre> theatres = ITheatreService.getAllTheatre();
//		return new ResponseEntity<Iterable<Theatre>>(theatres,HttpStatus.OK);
//	}
}
