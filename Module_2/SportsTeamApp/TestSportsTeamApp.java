package Module_2.SportsTeamApp;

import java.util.Scanner;

public class TestSportsTeamApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        
        System.out.println("  Welcome to the Sports Team App");

        do {
            // Get team name from user
            System.out.print("\n  Enter a team name: ");
            String teamName = scanner.nextLine();

            // Create a Team object
            Team team = new Team(teamName);

            // Get player names from user
            System.out.print("\n  Enter the player names:\n  hint: use commas for multiple players; no spaces>: ");
            String playersInput = scanner.nextLine();
            String[] playerNames = playersInput.split(",");

            // Add players to the team
            for (String player : playerNames) {
                team.addPlayer(player);
            }

            // Display team summary
            System.out.println("\n  --Team Summary--");
            System.out.println("  Number of players in team: " + team.getPlayerCount());
            System.out.println("  Players on team: " + team.getPlayers());

            // Ask user if they want to continue
            System.out.print("\n  Continue? (y/n): ");
            choice = scanner.nextLine().trim().toLowerCase();

        } while (choice.equals("y"));

        System.out.println("\n  End of line...");
        scanner.close();
    }
}
