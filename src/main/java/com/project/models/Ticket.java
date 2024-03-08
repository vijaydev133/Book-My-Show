package com.project.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String MovieName;
	
	private int totalAmount;
	
	private LocalDate showDate;
	
	private LocalTime showTime;
	
	private String ticketId=UUID.randomUUID().toString();
	private String	theatreName;
	
	
	
	@ManyToOne
	@JoinColumn
	private UserDetails userDetails;
	
	@ManyToOne
	@JoinColumn
	private ShowDetails showDetails;
	
}
