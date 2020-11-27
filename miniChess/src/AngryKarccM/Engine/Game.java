package AngryKarccM.Engine;


import AngryKarccM.Arena.Arena;
import AngryKarccM.Default;
import AngryKarccM.Players.Player;
import AngryKarccM.ROCKS.Rock;
import AngryKarccM.ROCKS.RockFactory;

import java.util.ArrayList;

public class Game implements Runnable{
    Player ppl;
    Arena arena;
    Engine engine;

    public Game(Player ppl){
        this.ppl = ppl;
        // -- Knight Game --

        //board dim
        arena = new Arena(Default.tableSizeX , Default.tableSizeY);
        //init knight
        ArrayList rocks = new ArrayList<Rock>();
        rocks.add(RockFactory.get(ppl));

        ppl.setRocks(rocks);
        // inti ENGINE
        engine = new Engine(Default.goal);
        // test the goal
        arena.validateGoal(Default.goal);
    }

    @Override
    public void run() {
        while(!State.finish){
            ArrayList squares;
                for(int j = 0 ; j < ppl.getRocks().size() ; j++){
                    //display arena
                    arena.print_Arena();

                    // available Squares Depend on player rocks
                    squares = engine.getNewPlaces((Rock) ppl.getRocks().get(j));

                    //let player decide
                    Move x = new Move((Rock) ppl.getRocks().get(j));
                    //apply move on rock
                    x.doMove(ppl.makeAction(squares));

                    //Check if game still running , Mean he hasn't win yet :D
                    engine.checker(ppl.getRocks());

                    //get rocks in new position
                    arena.update(ppl.getRocks());
                }
            
        }
        System.out.println("We Have Winner Here :D ");
    }
}
