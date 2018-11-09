package io.zipcoder.casino;


import io.zipcoder.casino.cardgames.BlackJack;
import io.zipcoder.casino.cardgames.GoFish;
import io.zipcoder.casino.dicegames.Craps;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.Players;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.abstracts.Game;

public class Casino {
    private Game game;
    Players players = Players.getInstance();
    Console console = new Console();
    boolean continueGame = true;

    public static void main(String[] args) {
        Casino casino = new Casino();

//before game
        casino.enterPlayers();
        while (casino.continueGame == true) {
            //ADD LOOP
            casino.chooseTable();

//after game
            casino.printBalance();
            casino.bootPlayer();
        }
    }

    public void enterPlayers() {
        int numberOfPlayers = getNumberOfPlayers();
        String playerNames = "";
        playerNames = getPlayerNames(numberOfPlayers, playerNames);
        console.println(playerNames + "THANK YOU FOR JOINING US");
    }

    private String getPlayerNames(int numberOfPlayers, String playerNames) {
        for (int i = 1; i <= numberOfPlayers; i++) {
          String nameOfPlayer = console.getStringInput("\nPLAYER " + i + ": WHAT IS YOUR NAME?");
          players.addPlayer(new Player(nameOfPlayer));
          playerNames += nameOfPlayer + ", ";
        }
        return playerNames;
    }

    private int getNumberOfPlayers() {
        return console.getIntegerInput("*********************************\n" +
                "    WELCOME TO EPSILON CASINO\n---------------------------------\n" +
                "CALLED \"ALMOST A CASINO\" ON YELP\n*********************************\n" +
                "\nPLEASE ENTER A NUMBER OF PLAYERS.");
    }

    public void chooseTable() {
        Game game = null;

        Integer gameChoice = console.getGameChoice();

        switch(gameChoice){
            case 1:
                game = new Craps();
                break;
            case 2:
                game = new BlackJack();
                break;
            case 3:
                game = new GoFish();
                break;
        }
        runGame(game);
     }

    private void runGame(Game game) {
        this.game = game;
    }

    public void bootPlayer() {
        // If player balance is 0, player game over
        for (int i = 0; i < players.getPlayers().size(); i++) {
          if(players.getPlayers().get(i).getChipBalance()<=0){
            console.println(players.getPlayers().get(i).getName() + ", YOU ARE BROKE. GTFO, PEASANT.");
            players.removePlayer(players.getPlayers().get(i));
          }
        }
    }

    public void printBalance() {
      for (Player player : players.getPlayers()){
        console.println(String.format(player.getName() + " has " + player.getChipBalance() + " chips.\n"));
      }
    }

    public void promptContinue() {
        String continueChoice = console.getStringInput("Would you like to play another game? Y/N");
        if (continueChoice.equalsIgnoreCase("n")) continueGame = false;
    }


}
