package io.zipcoder.casino;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackJackPlayerTest {
    Player player = new Player("Mr. Guy");

    @Before
    public void setUp() throws Exception {
        BlackJackPlayer b = new BlackJackPlayer(player);
    }

    @Test
    public void hit() {
    }

    @Test
    public void stay() {
    }

    @Test
    public void getHand() {
    }

    @Test
    public void setHand() {
    }
}