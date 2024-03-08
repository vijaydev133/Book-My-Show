package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.ShowSeat;

public interface IShowSeatDao extends JpaRepository<ShowSeat, Integer> {

}
