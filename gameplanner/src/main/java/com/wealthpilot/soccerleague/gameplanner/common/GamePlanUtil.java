package com.wealthpilot.soccerleague.gameplanner.common;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wealthpilot.soccerleague.gameplanner.model.SoccerLeague;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GamePlanUtil {
	
	public  static SoccerLeague generatePojo() {
		ObjectMapper mapper = new ObjectMapper();
		SoccerLeague league=null;
		TypeReference<SoccerLeague> soccerLeagueType = new TypeReference<SoccerLeague>() {};
		InputStream is = TypeReference.class.getResourceAsStream("/soccer_teams.json");
		try {
			league =  mapper.readValue(is, soccerLeagueType);
			
		} catch (IOException e) {
			log.error("Not able to convert the json data");
		}
		return league;
	}

}
