package com.pl.Premier_League_App.controller;

import com.pl.Premier_League_App.player.Player;
import com.pl.Premier_League_App.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation) {

        // --- DEBUG PRINTS (Check your IntelliJ Run Console!) ---
        System.out.println("Search Request Received:");
        System.out.println("Name Param: '" + name + "'");
        System.out.println("Team Param: '" + team + "'");
        // -------------------------------------------------------

        // 1. PRIORITY: Search by Name
        if (name != null && !name.trim().isEmpty()) {
            System.out.println("✅ Executing Name Search for: " + name);
            return playerService.getPlayerByName(name);
        }

        // 2. Search by Team & Position
        if (team != null && !team.trim().isEmpty() && position != null && !position.trim().isEmpty()) {
            System.out.println("✅ Executing Team + Pos Search");
            return playerService.getPlayerByTeamAndPosition(team, position);
        }

        // 3. Search by Team
        if (team != null && !team.trim().isEmpty()) {
            System.out.println("✅ Executing Team Search");
            return playerService.getPlayersFromTeam(team);
        }

        // 4. Default: Return All
        System.out.println("⚠️ No valid filters found. Returning ALL players.");
        return playerService.getPlayers();
    }

    // ... (Keep your Add, Update, Delete methods the same) ...
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        return new ResponseEntity<>(playerService.addPlayer(player), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player updatedPlayer) {
        Player result = playerService.updatePlayer(updatedPlayer);
        return result != null ? new ResponseEntity<>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}