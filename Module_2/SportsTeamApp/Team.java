package Module_2.SportsTeamApp;
import java.util.Scanner;

import java.util.Arrays;

public class Team {
    private String teamName;
    private String[] players;
    private int playerCount;
    
    // Default values
    private static final int MAX_PLAYERS = 20;

    // Constructor
    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new String[MAX_PLAYERS];
        this.playerCount = 0;
    }

    // Method to add a player
    public void addPlayer(String player) {
        if (playerCount < MAX_PLAYERS) {
            players[playerCount] = player;
            playerCount++;
        } else {
            System.out.println("Team is full! Cannot add more players.");
        }
    }

    // Getter for team name
    public String getTeamName() {
        return teamName;
    }

    // Getter for players (returns as a formatted string)
    public String getPlayers() {
        return String.join(",", Arrays.copyOf(players, playerCount));
    }

    // Getter for player count
    public int getPlayerCount() {
        return playerCount;
    }
}
