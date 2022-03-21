package com.wealthpilot.soccerleague.gameplanner.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team implements Serializable{

	
	
	private static final long serialVersionUID = 1L;
	private String name;
	@JsonProperty("founding_date")
	private String 	foundingdate;
}
