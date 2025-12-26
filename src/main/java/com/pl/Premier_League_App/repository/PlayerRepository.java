package com.pl.Premier_League_App.repository;

import com.pl.Premier_League_App.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, String> {

    void deleteByName(String playerName);
    Optional<Player> findByName(String name);

    // ✅ ADD THESE NEW METHODS:

    // Finds players where name contains the text (case insensitive)
    List<Player> findByNameContainingIgnoreCase(String name);

    // Finds players by team (exact match)
    List<Player> findByTeam(String team);

    // Finds players by team AND position
    List<Player> findByTeamAndPos(String team, String pos);
}