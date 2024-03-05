package com.hexaware.codingchallenge.service;

import java.util.List;

import com.hexaware.codingchallenge.dto.PlayerDTO;
import com.hexaware.codingchallenge.entities.Player;
import com.hexaware.codingchallenge.exception.PlayerNotFoundException;

public interface IPlayerService {
	public Player insertPlayer(PlayerDTO playerDto);
	public Player updatePlayerById(PlayerDTO playerDto, long playerId);
	
	public Player getPlayerById(long playerId);
	public List<Player> getAllPlayers();
	
	public String deletePlayerById(long playerId) throws PlayerNotFoundException;
	
	//coding challenge
	public List<String> getPlayersWithMoreMatchesThan(String playerName) throws PlayerNotFoundException;
}
