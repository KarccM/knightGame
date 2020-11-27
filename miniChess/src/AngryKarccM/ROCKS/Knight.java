package AngryKarccM.ROCKS;

import AngryKarccM.Arena.Square;
import AngryKarccM.Engine.Node;

import java.util.ArrayList;

public class Knight extends Rock{
    Knight(int x , int y){
        this.moveType = "L";
        this.name = "Knight";
        this.node = new Node();
    }
    public Knight(Node node){
        this.moveType = "L";
        this.name = "Knight";
        this.node = node;
    }

    Knight(Square square){
        this.moveType = "L";
        this.name = "Knight";
        this.node = new Node(square);
    }

    public Knight(){
        this.moveType = "L";
        this.name = "Knight";
        this.node = new Node();
    }



    /*
    we need to implement copy method
    * Search for Deep Copy *
     */

    @Override
    public void update(Node node) {
        this.node = node;
    }
}
