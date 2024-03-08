package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.ShowDetails;

public interface IShowDao extends JpaRepository<ShowDetails, Integer> {

}
