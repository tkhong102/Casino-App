package io.zipcoder.casino;

import java.util.Scanner;

public class Console {
    public void gamePick(){
        System.out.println("Welcome to casino");
        System.out.println("GameList\n") ;
        System.out.println("1.BLACK JACK");
        System.out.println("2.CRAPS");
        System.out.println("3.GO FISH");
        Scanner

    }

    public void input() {
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
        System.out.println("Do you want to playagain");
        Scanner pRes=new Scanner(System.in ) ;
        String playerRespone=pRes.nextLine() ;
        if(playerRespone.equals(compare) )
        {
            input();
        }
        else
        {
            System.out.println("Thank you for playing");
        }
    }
    public void output() {


    }


}
