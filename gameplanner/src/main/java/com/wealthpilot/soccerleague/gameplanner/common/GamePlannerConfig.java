package com.wealthpilot.soccerleague.gameplanner.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wealthpilot.soccerleague.gameplanner.model.SoccerLeague;

@Configuration
public class GamePlannerConfig {

	
	@Bean
	public SoccerLeague getSoccerLeague() {
		return GamePlanUtil.generatePojo1(SoccerLeague.class);
		
	}
}
