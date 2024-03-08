package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ITheatreDao;
import com.project.entryDtos.TheatreEntryDTO;
import com.project.enums.SeatType;
import com.project.models.Theatre;
import com.project.models.TheatreSeat;


@Service
public class TheatreServiceImpl implements ITheatreService {

	@Autowired
	private ITheatreDao theatreDao;
	@Override
	public String addTheatre(TheatreEntryDTO theatreEntryDTO) {
		// TODO Auto-generated method stub
		Theatre theatre = Theatre.builder()
				.name(theatreEntryDTO.getName())
				.location(theatreEntryDTO.getLocation())
				.build();
		
		List<TheatreSeat> theatreSeat = createTheatreSeats(theatreEntryDTO, theatre);
		
		theatre.setTheatreSeat(theatreSeat);
		
		return theatreDao.save(theatre).getId()+" theatre added successfully";
	}

	private List<TheatreSeat> createTheatreSeats(TheatreEntryDTO theatreEntryDTO, Theatre theatre) {
		// TODO Auto-generated method stub
		List<TheatreSeat> theatreSeats = new ArrayList<>();
		
		int premium = theatreEntryDTO.getPremiumCount();
		int classic = theatreEntryDTO.getClassicCount();
		
		for(int i=1; i<=premium; i++) {
			TheatreSeat theatreSeat = TheatreSeat.builder()
					.seatType(SeatType.PREMIUM)
					.seatNo(i+"P")
					.theatre(theatre)
					.build();
			
			theatreSeats.add(theatreSeat);
		}
		
		for(int i=1; i<=classic; i++) {
			TheatreSeat theatreSeat = TheatreSeat.builder()
					.seatType(SeatType.CLASSIC)
					.seatNo(i+"C")
					.theatre(theatre)
					.build();
			
			theatreSeats.add(theatreSeat);
		}
		
//		theatre.se
		
		return theatreSeats;
	}

	@Override
	public Iterable<Theatre> getAllTheatre() {
		// TODO Auto-generated method stub
		return theatreDao.findAll();
	}

}
