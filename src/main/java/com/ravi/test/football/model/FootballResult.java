package com.ravi.test.football.model;

public class FootballResult {

	private String countryInfo;
	private String leagueInfo;
	private String teamInfo;
	private String leaguePosition;
	public String getCountryInfo() {
		return countryInfo;
	}
	public void setCountryInfo(String countryInfo) {
		this.countryInfo = countryInfo;
	}
	public String getLeagueInfo() {
		return leagueInfo;
	}
	public void setLeagueInfo(String leagueInfo) {
		this.leagueInfo = leagueInfo;
	}
	public String getTeamInfo() {
		return teamInfo;
	}
	
	public void setTeamInfo(String teamInfo) {
		this.teamInfo = teamInfo;
	}
	public String getLeaguePosition() {
		return leaguePosition;
	}
	public void setLeaguePosition(String leaguePosition) {
		this.leaguePosition = leaguePosition;
	}
	@Override
	public String toString() {
		return "FootballResult [countryInfo=" + countryInfo + ", leagueInfo=" + leagueInfo + ", teamInfo=" + teamInfo
				+ ", leaguePosition=" + leaguePosition + "]";
	}
	
}
