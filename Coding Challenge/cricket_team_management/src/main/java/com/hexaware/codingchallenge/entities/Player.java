package com.hexaware.codingchallenge.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Entity
public class Player {
	
	@Id
	@Min(100)
	@Max(999)
	private Long playerId;
	private String playerName;
	@Min(1)
	@Max(999)
	private int jerseyNumber;
	@Pattern(regexp = "(Batsman|Bowler|Wicket keeper|All Rounder)", message = "Invalid role")
	private String role;
	@Min(0)
	private Long totalMatches;
	private String teamName;
	private String countryName;
	private String description;
	
	public Player() {
		
	}

	public Player(@Min(100) @Max(999) Long playerId, String playerName, int jerseyNumber, String role,
			Long totalMatches, String teamName, String countryName, String description) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.jerseyNumber = jerseyNumber;
		this.role = role;
		this.totalMatches = totalMatches;
		this.teamName = teamName;
		this.countryName = countryName;
		this.description = description;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(Long totalMatches) {
		this.totalMatches = totalMatches;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", jerseyNumber=" + jerseyNumber
				+ ", role=" + role + ", totalMatches=" + totalMatches + ", teamName=" + teamName + ", countryName="
				+ countryName + ", description=" + description + "]";
	}
	
}
