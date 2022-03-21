package com.wealthpilot.soccerleague.gameplanner.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match implements Serializable {


	private static final long serialVersionUID = 1L;
	private Team homeTeam;
	private Team otherteam;
	private LocalDate matchDate;
	

}
