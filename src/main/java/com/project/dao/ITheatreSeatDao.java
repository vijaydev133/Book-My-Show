package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.TheatreSeat;

public interface ITheatreSeatDao extends JpaRepository<TheatreSeat, Integer> {

}
