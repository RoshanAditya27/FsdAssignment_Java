package com.hexaware.codingchallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.codingchallenge.dto.PlayerDTO;
import com.hexaware.codingchallenge.entities.Player;
import com.hexaware.codingchallenge.exception.PlayerNotFoundException;
import com.hexaware.codingchallenge.service.IPlayerService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/players")
public class PlayerController {

	@Autowired
	IPlayerService playerService;
	
	@PostMapping("/add")
	public Player addPlayer(@RequestBody @Valid PlayerDTO playerDto) {
		return playerService.insertPlayer(playerDto);
	}
	
	@PutMapping("/update/{playerId}")
	public Player updatePlayerById(@PathVariable long playerId, @RequestBody @Valid PlayerDTO playerDto) throws PlayerNotFoundException {
		Player player = playerService.updatePlayerById(playerDto, playerId);
		
		if(player == null)
			throw new PlayerNotFoundException("Player with given ID not found!");
		
		return player;
	}
	
	@GetMapping("/get-player-by-id/{playerId}")
	public Player getPlayerById(@PathVariable long playerId) {
		return playerService.getPlayerById(playerId);
	}
	
	@GetMapping("/get-all-players")
	public List<Player> getAllPlayers() {
		return playerService.getAllPlayers();
	}
	
	@DeleteMapping("delete-player-by-id/{playerId}")
	public String deletePlayerById(@PathVariable long playerId) throws PlayerNotFoundException {
		return playerService.deletePlayerById(playerId);
	}
	
	@GetMapping("/get-players-with-more-matches-than/{playerName}")
	public List<String> getPlayersWithMoreMatchesThan(@PathVariable String playerName) throws PlayerNotFoundException {
		return playerService.getPlayersWithMoreMatchesThan(playerName);
	}
}
