package com.sipl.vehiclemanagementsystem.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

	private HttpStatus status;
	private String message;
	private boolean error;

}