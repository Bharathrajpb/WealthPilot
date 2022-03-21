package com.wealthpilot.soccerleague.gameplanner.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoccerLeague implements Serializable{

	private static final long serialVersionUID = 1L;
	private String league;
	private String country;
	private List<Team> teams;
}
