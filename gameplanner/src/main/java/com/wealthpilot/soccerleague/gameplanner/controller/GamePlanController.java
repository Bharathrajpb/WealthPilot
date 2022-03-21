package com.wealthpilot.soccerleague.gameplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wealthpilot.soccerleague.gameplanner.common.ResponseUtil;
import com.wealthpilot.soccerleague.gameplanner.model.ScheduledMatchResponse;
import com.wealthpilot.soccerleague.gameplanner.service.GamePlanService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/gameplanner")
@Slf4j
public class GamePlanController {

	@Autowired
	private GamePlanService gamePlanService;

	@GetMapping(value = "/seasonplan")
	public ResponseEntity<ScheduledMatchResponse> getGamePlanForSeason() {
		log.info("Entred");
		ScheduledMatchResponse response= gamePlanService.prepareGamePlanForSeason();
		log.info("Season Matches Scheduled..sending back the response");
		return  ResponseUtil.response200(response);
				
	}

}
