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

    public static void main(String[] args) {
        Casino casino = new Casino();

//before game
        casino.enterPlayers();
        //ADD LOOP
        casino.chooseTable();

//after game
        casino.printBalance();
        casino.bootPlayer();
    }

    public void enterPlayers() {
        int numberOfPlayers = getNumberOfPlayers();
        String playerNames = "";
        playerNames = getPlayerNames(numberOfPlayers, playerNames);
        console.println(playerNames + "THANK YOU FOR JOINING US");
    }

    private String getPlayerNames(int numberOfPlayers, String playerNames) {
        for (int i = 1; i <= numberOfPlayers; i++) {
          String nameOfPlayer = console.getStringInput("PLAYER " + i + ": WHAT IS YOUR NAME?\n");
          players.addPlayer(new Player(nameOfPlayer));
          playerNames += nameOfPlayer + ", ";
        }
        return playerNames;
    }

    private int getNumberOfPlayers() {
        return console.getIntegerInput("WELCOME TO EPSILON CASINO, CALLED \"ALMOST A CASINO\" ON YELP\n" +
                  "PLEASE ENTER A NUMBER OF PLAYERS.");
    }

    public void chooseTable() {

      console.println("GAME LIST\n");
      console.println("1. CRAPS\n");
      console.println("2. BLACK JACK\n");
      console.println("3. GO FISH\n");
      console.println("CHOOSE TABLE\n");
      Integer number=console.getIntegerInput("") ;
       switch(number){
         case 1:
             runGame(new Craps());
             break;
        case 2:
             runGame(new BlackJack());
             break;
        case 3:
             runGame(new GoFish());
             break;
       }        
     }

    private void runGame(Game game) {
        console.println("WELCOME TO %s", game.getClassName());
        this.game = game;
    }

    public void confirmPlayers() {
      boolean isConfirmed = false;
      while(!isConfirmed){
        console.println("Current Players: ");
        for(Player player : players.getPlayers()){
          console.println(player.getName());
        }
        Integer choice = console.getIntegerInput("Choose option:\n (1)Confirm Players\n (2)Add Player\n (3)Remove Player\n");
        String name;
        switch(choice){
          case 1: isConfirmed = true;
            break;
          case 2: name = console.getStringInput("Enter name of player to add: ");
                    players.addPlayer(new Player(name));
            break;
          case 3: name = console.getStringInput("Enter name of player to remove: ");
                  for(Player player : players.getPlayers()){
                    if(player.getName() == name)
                      players.removePlayer(player);
                  }
            break;
          default: break;
        }
      }
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
      console.println("FYI guys:\n");
      for (Player player : players.getPlayers()){
        console.println(String.format(player.getName() + " has " + player.getChipBalance() + " chips.\n"));
      }
    }


}
