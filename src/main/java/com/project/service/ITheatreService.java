package com.project.service;

import com.project.entryDtos.TheatreEntryDTO;
import com.project.models.Theatre;

public interface ITheatreService {

	String addTheatre(TheatreEntryDTO theatreEntryDTO);
	
	Iterable<Theatre> getAllTheatre();
}
