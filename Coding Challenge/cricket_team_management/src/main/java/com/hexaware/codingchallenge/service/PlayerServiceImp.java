package com.hexaware.codingchallenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.codingchallenge.dto.PlayerDTO;
import com.hexaware.codingchallenge.entities.Player;
import com.hexaware.codingchallenge.exception.PlayerNotFoundException;
import com.hexaware.codingchallenge.repository.PlayerRepository;

@Service	
public class PlayerServiceImp implements IPlayerService{

	@Autowired
	PlayerRepository playerRepo;
	
	@Override
	public Player insertPlayer(PlayerDTO playerDto) {
		Player player = new Player();
		player.setPlayerId(playerDto.getPlayerId());
		player.setPlayerName(playerDto.getPlayerName());
		player.setJerseyNumber(playerDto.getJerseyNumber());
		player.setRole(playerDto.getRole());
		player.setTotalMatches(playerDto.getTotalMatches());
		player.setCountryName(playerDto.getCountryName());
		player.setTeamName(playerDto.getTeamName());
		player.setDescription(playerDto.getDescription());
		
		return playerRepo.save(player);
	}

	@Override
	public Player updatePlayerById(PlayerDTO playerDto, long playerId) {
		Optional<Player> existingPlayer = playerRepo.findById(playerId);
		Player player = null;
		
		if(existingPlayer.isPresent())
		{
			player = existingPlayer.get();
			player.setPlayerName(playerDto.getPlayerName());
			player.setJerseyNumber(playerDto.getJerseyNumber());
			player.setRole(playerDto.getRole());
			player.setTotalMatches(playerDto.getTotalMatches());
			player.setTeamName(playerDto.getTeamName());
			player.setCountryName(playerDto.getCountryName());
			player.setDescription(playerDto.getDescription());
			
			return playerRepo.save(player);
		}
		else {
			return null;
		}
	}

	@Override
	public Player getPlayerById(long playerId) {
		return playerRepo.findById(playerId).orElse(null);
	}

	@Override
	public List<Player> getAllPlayers() {
		return playerRepo.findAll();
	}

	@Override
	public String deletePlayerById(long playerId) throws PlayerNotFoundException {
		Optional<Player> existingPlayer = playerRepo.findById(playerId);
		if(existingPlayer.isPresent()) {
			playerRepo.deleteById(playerId);
			
			return "Player deleted successfully";
		}
		else
			throw new PlayerNotFoundException("Player with given ID doesn not exist!");
		
		
	}

	@Override
	public List<String> getPlayersWithMoreMatchesThan(String playerName) throws PlayerNotFoundException {
		if(!checkValid(playerName)) {
			throw new IllegalArgumentException("Player name should start with capital letter.");
		}
		List <String> players = playerRepo.findPlayersWithMoreMatchesThan(playerName);
		if(players.isEmpty())
		{
			throw new PlayerNotFoundException("No players found with the given name.");
		}
		
		return players;
	}

	private boolean checkValid(String playerName) {
		return Character.isUpperCase(playerName.charAt(0));
	}

}
