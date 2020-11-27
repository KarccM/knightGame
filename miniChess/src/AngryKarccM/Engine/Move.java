package AngryKarccM.Engine;

import AngryKarccM.ROCKS.Rock;

public class Move {

    private final Rock rock;

    public Move(Rock rock) {
        this.rock = rock;
    }

    public void doMove(Node node){
        rock.update(node);
    }

}
