package com.project.error;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {

	private LocalDateTime date;
	
	private String msg;
	
	private String errorCode;
}
