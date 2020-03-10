package com.ravi.test.football.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FootballTeam {

	
	@JsonProperty("team_key")
	private String teamKey;
	
	@JsonProperty("team_name")
	private String teamName;

	@Override
	public String toString() {
		return "FootballTeam [teamKey=" + teamKey + ", teamName=" + teamName + "]";
	}

	public String getTeamKey() {
		return teamKey;
	}

	public void setTeamKey(String teamKey) {
		this.teamKey = teamKey;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
}
