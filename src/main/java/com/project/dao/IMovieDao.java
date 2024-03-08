package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.Movie;

public interface IMovieDao extends JpaRepository<Movie, Integer> {

}
