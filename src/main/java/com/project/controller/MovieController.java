package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entryDtos.MovieEntryDTO;
import com.project.models.Movie;
import com.project.service.IMovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private IMovieService movieService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addMovie(@RequestBody MovieEntryDTO movieDto){
		String msg= movieService.addMovie(movieDto);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/getAllMovie")
	public ResponseEntity<Iterable<Movie>> getAllMovie(){
		Iterable<Movie> movies = movieService.getAllMovie();
//		for(Movie mov: movies) {
//			System.out.println(mov);
//		}
		return new ResponseEntity<Iterable<Movie>>(movies,HttpStatus.OK);
	}
}
