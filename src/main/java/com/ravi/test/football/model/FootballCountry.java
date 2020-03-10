package com.ravi.test.football.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FootballCountry {

	@JsonProperty("country_id")
	private String countryId;
	
	@JsonProperty("country_name")
	private String counryName;
	
	@JsonProperty("country_logo")
	private String countryLogo;
	
	@Override
	public String toString() {
		return "FootballCountry [countryId=" + countryId + ", counryName=" + counryName + ", countryLogo=" + countryLogo
				+ ", getCountryId()=" + getCountryId() + ", getCounryName()=" + getCounryName() + ", getCountryLogo()="
				+ getCountryLogo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCounryName() {
		return counryName;
	}
	public void setCounryName(String counryName) {
		this.counryName = counryName;
	}
	public String getCountryLogo() {
		return countryLogo;
	}
	public void setCountryLogo(String countryLogo) {
		this.countryLogo = countryLogo;
	}
	
}
