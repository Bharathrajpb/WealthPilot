package com.wealthpilot.soccerleague.gameplanner.model;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScheduledMatchResponse implements Serializable {
	private List<Match> matches;

	@Override
	public String toString() {
		return "ScheduledMatchResponse [matches=" + matches + "]";
	}
	
	
}
