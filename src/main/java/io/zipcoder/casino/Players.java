package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.List;

public class Players<P> extends ArrayList<Player> {

    public Players(List<Player> playerList) {
        addAll(playerList);
    }

}
