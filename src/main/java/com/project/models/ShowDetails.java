package com.project.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.enums.SeatType;
import com.project.enums.ShowType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDate showDate;
	
	private LocalTime showTime;
	
	@Enumerated(EnumType.STRING)
	private ShowType showType;
	
	@CreationTimestamp
	private Date createdOn;
	
	@UpdateTimestamp
	private Date updatedOn;
	
	 
	@ManyToOne
	@JoinColumn(name = "movieId")
	private Movie movie;
	
	 
	@ManyToOne
	@JoinColumn
	private Theatre theatre;
	
	@OneToMany(mappedBy = "showDetails",cascade = CascadeType.ALL)
	private List<Ticket> bookedTickets;
	
	@OneToMany(mappedBy = "showDetails",cascade = CascadeType.ALL)
	private List<ShowSeat> ShowSeats;
}
