package com.project.entryDtos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.project.enums.ShowType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowEntryDTO {
	
private LocalDate showDate;
	
	private LocalTime showTime;
	
	
//	private ShowType showType;
	
	private int theatreId;
	
	private int movieId;
	
	private int premiumCost;
	
	private int classicCost;
	
//	private int price;
}
