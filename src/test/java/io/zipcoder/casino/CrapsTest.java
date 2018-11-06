package io.zipcoder.casino;

import org.junit.Test;
import org.junit.Assert;

import java.util.*;

public class CrapsTest {

    @Test
    public void testCraps(){
        //Given
        ArrayList<CrapsPlayer> playerz = new ArrayList<>();
        CrapsPlayer cplayer1 = new CrapsPlayer(new Player("Bob",100));
        CrapsPlayer cplayer2 = new CrapsPlayer(new Player("Joe",100));
        CrapsPlayer cplayer3 = new CrapsPlayer(new Player("Will",100));

        playerz.add(cplayer1);
        playerz.add(cplayer2);
        playerz.add(cplayer3);

        Craps newCraps = new Craps(playerz);
        newCraps.print();
        //When
        //Then
    }

}
