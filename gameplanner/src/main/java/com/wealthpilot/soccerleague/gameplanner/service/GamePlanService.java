package com.wealthpilot.soccerleague.gameplanner.service;

import com.wealthpilot.soccerleague.gameplanner.model.ScheduledMatchResponse;

public interface GamePlanService {

	public ScheduledMatchResponse prepareGamePlanForSeason();
}
