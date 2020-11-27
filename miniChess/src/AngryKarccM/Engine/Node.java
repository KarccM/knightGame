package AngryKarccM.Engine;

import AngryKarccM.Arena.Square;
import java.util.ArrayList;

public class Node {
/*
we need to add start pos and des
maybe we need to store value this related to rank of this move
 */
    Square place;
    ArrayList<Square> path;
    int value = 0;
    public Node(){
        place = new Square(0,0);
        path = new ArrayList<>();
    }

    public Node(Square place){
        this.place = place;
        path = new ArrayList<>();
    }

    public Node(Square place , ArrayList path){
        this.place = place;
        this.path  = path;
        path.add(place);
    }

    public Node(Node node , ArrayList path){
        this.place = node.place;
        this.path  = path;
        path.add(place);
    }

    public ArrayList<Square> getPath() {
        return path;
    }


    public void setPlace(Square place) {
        path.add(this.place);
        this.place = place;
    }
    public Square getPlace() {
        return place;
    }

    public void setPath(ArrayList<Square> path) {
        this.path = path;
    }

    @Override
    public String toString() {
        System.out.println("PATH : " + path);
        return place.toString();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}