package com.ravi.test.football.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FootballLeague {

	@JsonProperty("country_id")
	private String countryId;
	
	@JsonProperty("country_name")
	private String countryName;
	@JsonProperty("league_name")
	private String leagueName;
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public String getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}
	@JsonProperty("league_id")
	private String leagueId;
	
	@Override
	public String toString() {
		return "FootballLeague [countryId=" + countryId + ", countryName=" + countryName + ", leagueName=" + leagueName
				+ ", leagueId=" + leagueId + "]";
	}
}
