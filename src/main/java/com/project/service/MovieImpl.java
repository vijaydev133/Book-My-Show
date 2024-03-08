package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IMovieDao;
import com.project.entryDtos.MovieEntryDTO;
import com.project.enums.Genre;
import com.project.enums.Language;
import com.project.models.Movie;

@Service
public class MovieImpl implements IMovieService {
	
	@Autowired
	private IMovieDao movieDao;

	

	@Override
	public Iterable<Movie> getAllMovie() {
		// TODO Auto-generated method stub
		return movieDao.findAll();
		
	}

	@Override
	public String addMovie(MovieEntryDTO movieEntryDTO) {
		// TODO Auto-generated method stub
		Movie movie = Movie.builder()
				.MovieName(movieEntryDTO.getMovieName())
				.rating(movieEntryDTO.getRating())
				.duration(movieEntryDTO.getDuration())
				.build();
		
		movie.setGenre(Genre.FICTIONAL);
		movie.setLanguage(Language.TAMIL);
		
		return movieDao.save(movie).getMovieId()+" movie added successfully";
	}

}
