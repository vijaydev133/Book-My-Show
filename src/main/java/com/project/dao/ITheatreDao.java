package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.Theatre;

public interface ITheatreDao extends JpaRepository<Theatre, Integer> {

}
