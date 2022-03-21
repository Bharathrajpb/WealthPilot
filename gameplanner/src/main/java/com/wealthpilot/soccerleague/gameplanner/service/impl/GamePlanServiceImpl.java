package com.wealthpilot.soccerleague.gameplanner.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wealthpilot.soccerleague.gameplanner.model.Match;
import com.wealthpilot.soccerleague.gameplanner.model.ScheduledMatchResponse;
import com.wealthpilot.soccerleague.gameplanner.model.SoccerLeague;
import com.wealthpilot.soccerleague.gameplanner.model.Team;
import com.wealthpilot.soccerleague.gameplanner.service.GamePlanService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GamePlanServiceImpl implements GamePlanService{

	private int scheduleCount;
	
	@Value(value = "${gameplan.seasonStartDate}")
	private String seasonStartDate;
	
	@Value(value = "${gameplan.leagueBreak}")
	private int leagueBreak;
	
	@Autowired
	private SoccerLeague league;
	
	@Override
	public ScheduledMatchResponse prepareGamePlanForSeason() {
//		/SoccerLeague league = GamePlanUtil.generatePojo();
		log.info("Generated Team List from Json"+league);
		final List<Team> teamList = league.getTeams();
		List<Match> matchlist = new ArrayList<Match>();

		for (int i = 0; i < teamList.size(); i++) {
			for (int j = i + 1; j < teamList.size(); j++) {
				List<Match> schedulematchlist = scheduleMatch(teamList.get(i), teamList.get(j));
				matchlist.addAll(schedulematchlist);
			}
		}
		System.out.println("DATE              Team1                 Team2");
		matchlist.forEach(match -> System.out.println(
				match.getMatchDate() + " | " + match.getHomeTeam().getName() + " | " + match.getOtherteam().getName()));
		return ScheduledMatchResponse.builder().matches(matchlist).build();
	}

	
	private  List<Match> scheduleMatch(Team homeTeam,Team otherTeam) {
		List<Match> matchList=new ArrayList<Match>();
		final Match match=Match.builder().homeTeam(homeTeam).otherteam(otherTeam).
				matchDate(calculateMatchDate(false)).build();
		matchList.add(match);
		
		final Match revengeMatch=Match.builder().homeTeam(otherTeam).otherteam(homeTeam).
				matchDate(calculateMatchDate(true)).build();
		matchList.add(revengeMatch);
		return matchList;
	}
	
	private LocalDate calculateMatchDate(boolean isRevengeMatch) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		 LocalDate localDate = LocalDate.parse(seasonStartDate, formatter);
		if(!isRevengeMatch) {
		  scheduleCount++;
		return localDate.plusDays(scheduleCount*7);
		}
		else {
			 return  localDate.plusWeeks(leagueBreak).plusDays(scheduleCount*7);
		}
	}
}
