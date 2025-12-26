package com.pl.Premier_League_App.service;

import com.pl.Premier_League_App.player.Player;
import com.pl.Premier_League_App.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    // ✅ FIX 1: Use DB query for Team search
    public List<Player> getPlayersFromTeam(String teamName) {
        return playerRepository.findByTeam(teamName);
    }

    // ✅ FIX 2: Use DB query for Name search (Solves your issue!)
    public List<Player> getPlayerByName(String searchText) {
        return playerRepository.findByNameContainingIgnoreCase(searchText);
    }

    // ✅ FIX 3: Use DB query for Team + Position
    public List<Player> getPlayerByTeamAndPosition(String team, String position) {
        return playerRepository.findByTeamAndPos(team, position);
    }

    // ... (Keep your add, update, delete methods exactly as they were) ...
    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    // ... rest of your code ...
    public Player updatePlayer(Player updatePlayer) {
        Optional<Player> existingPlayer = playerRepository.findByName(updatePlayer.getName());
        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setTeam(updatePlayer.getTeam());
            playerToUpdate.setPos(updatePlayer.getPos());
            playerToUpdate.setNation(updatePlayer.getNation());
            return playerRepository.save(playerToUpdate);
        }
        return null;
    }

    @Transactional
    public void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }
}