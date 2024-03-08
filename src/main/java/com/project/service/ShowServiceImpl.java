package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IMovieDao;
import com.project.dao.ITheatreDao;
import com.project.entryDtos.ShowEntryDTO;
import com.project.enums.SeatType;
import com.project.enums.ShowType;
import com.project.models.Movie;
import com.project.models.ShowDetails;
import com.project.models.ShowSeat;
import com.project.models.Theatre;
import com.project.models.TheatreSeat;

import jakarta.persistence.EnumType;


@Service
public class ShowServiceImpl implements IShowService {
	
	@Autowired
	private ITheatreDao theatreDao;
	@Autowired
	private IMovieDao movieDao;

	@Override
	public String addShow(ShowEntryDTO showEntryDTO) {
		// TODO Auto-generated method stub
		//create a showDetail object
		
		ShowDetails showDetail = ShowDetails.builder()
				.showTime(showEntryDTO.getShowTime())
				.showDate(showEntryDTO.getShowDate())
				.showType(ShowType._2D)
				.build();
		
		Theatre theatre = theatreDao.findById(showEntryDTO.getTheatreId()).get() ;
		
		Movie movie = movieDao.findById(showEntryDTO.getMovieId()).get();
		
		
		
		showDetail.setTheatre(theatre);
		showDetail.setMovie(movie);
		
		List<ShowSeat> showSeats = createShowSeats(showEntryDTO,showDetail);
		showDetail.setShowSeats(showSeats);
		theatre.getShowDetails().add(showDetail);
		movie.getShowDetails().add(showDetail);
		theatreDao.save(theatre);
		movieDao.save(movie);
		return "Show seat saved success";
	}

	private List<ShowSeat> createShowSeats(ShowEntryDTO showEntryDTO, ShowDetails showDetail) {
		// TODO Auto-generated method stub
		List<ShowSeat> showSeats = new ArrayList<>();
		
		List<TheatreSeat> theatreSeats = showDetail.getTheatre().getTheatreSeat();
		
		for(TheatreSeat i:theatreSeats) {
			ShowSeat showSeat = ShowSeat.builder()
					.seatNo(i.getSeatNo())
					.seatType(i.getSeatType())
//					.seatType(EnumType.valueOf(i.getSeatType()))
					.showDetails(showDetail)
					.build();
			
			if(i.getSeatType()==SeatType.CLASSIC) {
				showSeat.setPrice(showEntryDTO.getClassicCost());
			}else {
				showSeat.setPrice(showEntryDTO.getPremiumCost());
			}
			
			showSeats.add(showSeat);
			
			
			
		}
		
		return showSeats;
	}

}
