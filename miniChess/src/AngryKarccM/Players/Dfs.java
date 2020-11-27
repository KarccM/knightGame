package AngryKarccM.Players;

import AngryKarccM.Arena.Square;
import AngryKarccM.Default;
import AngryKarccM.Engine.Node;
import AngryKarccM.ROCKS.Knight;

import java.util.*;

public class Dfs extends Player{
    //Visited array
    private final boolean [][] visited = new boolean[Default.tableSizeX][Default.tableSizeY];

    //Queue
    Stack<Node> s;

    //dfs rocks ( only one knight in default)
    private ArrayList rocks;

    //how many time it take to arrive to goal
    private int tries;

    public Dfs(){
        s = new Stack<>();
        tries=0;
    }

    //dfs will decide what it will pick depend on it algorithm
    @Override
    public Node makeAction(ArrayList squares) {
        /*
        add sub trees(nodes) to stack
         */
        for (Object o : squares){
            s.add((Node) o);
        }
        //temp node and square
        Node n;
        Square square;
        /*
        we will take last node enter the stack and check if it visited or not ,
        if we didn't visited it then we will decide to pick it
         */
        do {
        n = s.pop();
        square = n.getPlace();
        }while(visited[n.getPlace().getX()][n.getPlace().getY()]);
        //Mark as visited node
        visited[square.getX()][square.getY()] = true;
        //count tries
        tries++;
        return n;
    }

    public ArrayList getRocks() {
        return rocks;
    }

    public int getTries() {
        return tries;
    }

    @Override
    public void setRocks(List rocks) {
        this.rocks = (ArrayList) rocks;
    }

    @Override
    public String toString() {
        System.out.println("IT NEED " + getTries() + " Tries to WIN in Dfs");
        return "";
    }
}
