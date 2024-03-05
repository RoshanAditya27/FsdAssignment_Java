package com.hexaware.codingchallenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.codingchallenge.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{
	
	@Query(
			value = "select player_name from player where total_matches > (select total_matches from player where player_name = ?1)", 
			nativeQuery = true)
	List<String> findPlayersWithMoreMatchesThan(String playerName);
}
