package com.project.service;

import org.springframework.stereotype.Service;

import com.project.entryDtos.ShowEntryDTO;

@Service
public interface IShowService {

	String addShow(ShowEntryDTO showEntryDTO);
}
