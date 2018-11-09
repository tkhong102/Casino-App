package io.zipcoder.casino;

import io.zipcoder.casino.dicegames.Craps;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Test;

import java.util.*;

public class CrapsTest {

    @Test
    public void testCraps(){
        //Given
        ArrayList<CrapsPlayer> playerz = new ArrayList<>();
        CrapsPlayer cplayer1 = new CrapsPlayer(new Player("Bob",100),5);
        CrapsPlayer cplayer2 = new CrapsPlayer(new Player("Joe",100),20);
        CrapsPlayer cplayer3 = new CrapsPlayer(new Player("Will",100),12);

        //When
        playerz.add(cplayer1);
        playerz.add(cplayer2);
        playerz.add(cplayer3);

        Craps newCraps = new Craps(playerz);
        newCraps.print();
        //When
        //Then
    }

}
