package io.zipcoder.casino.utilities;

import io.zipcoder.casino.Casino;

import java.awt.peer.SystemTrayPeer;
import java.util.Scanner;

public class Console {
   /* public void gamePick() {
        System.out.println("Welcome to casino");
        System.out.println("GameList\n");
        System.out.println("1.BLACKJACK");
        System.out.println("2.CRAPS");
        System.out.println("3.GO FISH");
        Scanner in = new Scanner(System.in);
        int gPick = in.nextInt();
        switch (gPick) {
            case 1:
                System.out.println(" Welcome to BlackJACK ");
                break;
            case 2:
                System.out.println(" Welcome to CRAPS ");
                break;
            case 3:
                System.out.println(" Welcome to GO FISH ");
                break;


        }
    }

    //Console class needs utilities for input and output that we can use anywhere;
    // a method for taking input() and producing a string and a method for printing output() to the console

    public void enterPlayers() {
        System.out.println("Enter number of Players");
        Scanner str=new Scanner(System.in);
        int numberOfPlayers=str.nextInt();
        System.out.println("Names of Player");
        Scanner s;

     //names of players

        for(int i=0;i<numberOfPlayers;i++ ) {
         s= new Scanner(System.in);
         String namesOfPlayers = s.nextLine();
     }
    }
    public void placeBet()
    {
        System.out.println("How much money do you want to bet");
        Scanner chipBet=new Scanner(System.in ) ;
        int cBet=chipBet.nextInt();
        if(cBet ==0)
        {
            System.out.println("sorry, you don't have enough money") ;
        }
        else
        {
            System.out.println("Welcome to the Game");
        }
    }
    public void playMore()
    {   String compare="yes";
        System.out.println("Do you want to play again");
        Scanner pRes=new Scanner(System.in ) ;
        String playerRespone=pRes.nextLine() ;

        if(playerRespone.equals(compare) )
        {
            enterPlayers();
        }
        else
        {
            System.out.println("Thank you for playing");
        }
    }

    public String askPlayerQuestion(){
        System.out.println("Who do you want to ask?");
        Scanner str=new Scanner(System.in );
        String nameOfPlayer=str.nextLine();
        return nameOfPlayer ;

    }
    public int  askCardQuestion(){
        System.out.println("What card are you looking for?");
        Scanner cards=new Scanner(System.in );
        int n=cards.nextInt() ;
        return n;
    }
    public void output() {


    }
*/
    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public static void printWcarrot(String output){
        System.out.println(output);
        System.out.print("> ");
    }


    public static String getStringInput(String prompt){
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
      }
     public Integer getIntegerInput(String prompt){
         Scanner scanner = new Scanner(System.in);
         println(prompt);
         int userInput = scanner.nextInt();
         return userInput;
     }
     public Integer integerInputSameLine(String prompt){
        Scanner scanner = new Scanner(System.in);
        printWcarrot(prompt);
        int userInput = scanner.nextInt();
        return userInput;
     }
     public static Long getLongInput(String prompt) {
         Scanner scanner = new Scanner(System.in);
         println(prompt);
         Long userInput = scanner.nextLong();
         return userInput;
     }
    public Double getDoubleInput(String prompt){
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        double userInput = scanner.nextDouble() ;
        return userInput;
    }

    public Integer getGameChoice() {
        println("================");
        println("GAME LIST\n");
        println("1. CRAPS\n");
        println("2. BLACK JACK\n");
        println("3. GO FISH\n");
        println("================");
        return getIntegerInput("\nCHOOSE TABLE");
    }


//
//    public Integer getPlayersInput(String prompt){
//        Scanner scanner = new Scanner(System.in);
//        println(prompt);
//        int userInput = scanner.nextInt();
//        return userInput;
//
//    }
//
//     public String getPlayerName(String prompt)
//     {
//         Scanner scanner = new Scanner(System.in);
//         println(prompt);
//         String userInput = scanner.nextLine();
//         return userInput;
//     }

}
