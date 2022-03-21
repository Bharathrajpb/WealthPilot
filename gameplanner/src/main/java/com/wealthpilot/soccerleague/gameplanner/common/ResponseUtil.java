package com.wealthpilot.soccerleague.gameplanner.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

	public static <T> ResponseEntity<T> response200(T object){
		return new ResponseEntity<T>(object,HttpStatus.OK);
	}
	
	

	
}
