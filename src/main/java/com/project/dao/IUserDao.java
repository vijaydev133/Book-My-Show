package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.UserDetails;

public interface IUserDao extends JpaRepository<UserDetails, Integer> {

}
