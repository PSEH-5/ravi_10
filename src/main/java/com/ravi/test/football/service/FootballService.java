package com.ravi.test.football.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ravi.test.football.model.FootballCountry;
import com.ravi.test.football.model.FootballLeague;
import com.ravi.test.football.model.FootballResult;
import com.ravi.test.football.model.FootballStanding;
import com.ravi.test.football.model.FootballTeam;
import com.ravi.test.football.utilties.FootballAppConstants;
@Service
public class FootballService {
    
	private RestTemplate restTemplate = new RestTemplate();
	
	public  FootballResult getResult(String countryName, String leagueName,String teamName) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		FootballResult result = new FootballResult();
		
		String url = "https://apiv2.apifootball.com";
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		        .queryParam("action", FootballAppConstants.GET_COUNTRIES)
		        .queryParam("APIkey", FootballAppConstants.API_KEY);
		
		
		ResponseEntity<List<FootballCountry>> response = restTemplate.exchange(
			      builder.toUriString(),
			      HttpMethod.GET,
			      null,
			      new ParameterizedTypeReference<List<FootballCountry>>(){});
		
		String countryId = null;
		for(FootballCountry country : response.getBody()) {
			if(country.getCounryName().equalsIgnoreCase(countryName)){
				countryId = country.getCountryId();
				break;
			}
		}
		result.setCountryInfo("CountyId & Name "+ countryId + " "+ countryName);
		getLeagues(countryId, leagueName,teamName,result);
		return result;
	}
	
	public void getLeagues(String countryId, String leagueName,String teamName,FootballResult result) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		String url = "https://apiv2.apifootball.com";
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		        .queryParam("action", FootballAppConstants.GET_LEAGUES)
		        .queryParam("country_id", countryId)
		        .queryParam("APIkey", FootballAppConstants.API_KEY);
		
		
		ResponseEntity<List<FootballLeague>> response = restTemplate.exchange(
			      builder.toUriString(),
			      HttpMethod.GET,
			      null,
			      new ParameterizedTypeReference<List<FootballLeague>>(){});
		
		response.getBody().forEach(System.out::println);
		
		String leagueId = null;
		for(FootballLeague league : response.getBody()) {
			if(league.getLeagueName().equalsIgnoreCase(leagueName)){
				leagueId = league.getLeagueId();
				break;
			}
		}
		result.setLeagueInfo("LeagueId & Name "+ leagueId + " " + leagueName);
		getTeams(leagueId,teamName, result);
		getStanding(leagueId,teamName,result);
	}
	
	public void getTeams(String leagueId,String teamName, FootballResult result) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		String url = "https://apiv2.apifootball.com";
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		        .queryParam("action", FootballAppConstants.GET_TEAMS)
		        .queryParam("league_id", leagueId)
		        .queryParam("APIkey", FootballAppConstants.API_KEY);
		
		
		ResponseEntity<List<FootballTeam>> response = restTemplate.exchange(
			      builder.toUriString(),
			      HttpMethod.GET,
			      null,
			      new ParameterizedTypeReference<List<FootballTeam>>(){});
		
		String teamId = null;
		for(FootballTeam team : response.getBody()) {
			if(team.getTeamName().equalsIgnoreCase(teamName)){
				leagueId = team.getTeamKey();
				break;
			}
		}
		result.setLeagueInfo("TeamId & Name "+ teamId + " " + teamName);
		
	}
	
	public void getStanding(String leagueId,String teamName,FootballResult result) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		String url = "https://apiv2.apifootball.com";
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		        .queryParam("action", FootballAppConstants.GET_STANDINGS)
		        .queryParam("league_id", leagueId)
		        .queryParam("APIkey", FootballAppConstants.API_KEY);
		
		
		ResponseEntity<List<FootballStanding>> response = restTemplate.exchange(
			      builder.toUriString(),
			      HttpMethod.GET,
			      null,
			      new ParameterizedTypeReference<List<FootballStanding>>(){});
		
		
		String teamPosition = null;
		for(FootballStanding standing : response.getBody()) {
			if(standing.getTeamName().equalsIgnoreCase(teamName)){
				teamPosition = standing.getPosition();
				break;
			}
		}
		result.setLeaguePosition("overal League Position "+ teamPosition);
	}
}


