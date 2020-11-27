package AngryKarccM.ROCKS;

import AngryKarccM.Default;
import AngryKarccM.Players.Human;
import AngryKarccM.Players.Player;
/*
This class Just for Set First Position For Knight By Default
 */
public class RockFactory {
    public static Rock get(Player player){
        if(player instanceof Human){
            return new Knight();
        }
        else {
            return new Knight(Default.start);
        }
    }
}
