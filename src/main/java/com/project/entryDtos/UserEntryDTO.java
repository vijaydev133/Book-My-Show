package com.project.entryDtos;

import java.util.List;

import com.project.models.Ticket;
import com.project.models.UserDetails;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntryDTO {

private String name;
	
	private int age;
	
	private String email;
	
	private long mobileNumber;
	
	private String address;
}
