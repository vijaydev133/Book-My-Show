package com.project.service;

import com.project.entryDtos.MovieEntryDTO;
import com.project.models.Movie;

public interface IMovieService {

	String addMovie(MovieEntryDTO movieEntryDTO);
	
	Iterable<Movie> getAllMovie();
}
