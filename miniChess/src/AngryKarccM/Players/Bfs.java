package AngryKarccM.Players;

import AngryKarccM.Arena.Square;
import AngryKarccM.Default;
import AngryKarccM.Engine.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs extends Player {
    //Visited array
    private final boolean [][] visited = new boolean[Default.tableSizeX][Default.tableSizeY];
    private Node choice = new Node();


    //Queue
    Queue<Node> q;

    //bfs rocks ( only one knight in default)
    private ArrayList rocks;

    //how many time it take to arrive to goal
    private int tries;

    public Bfs(){
        q = new LinkedList();
        tries =0;
    }

    /*
    in this function BFS will decide what it gonna take as next move
    (mean : it will pick first node in queue , return it to game class , game class
     will test if picked node's is goal ot not :p )
     */
    @Override
    public Node makeAction(ArrayList nodes) {

        //here we will add the suggested node to bfs queue
        for (Object o :nodes) {
            q.add((Node) o);
        }

        //temp node and square
        Node n;
        Square s;

        /*
        in this loop we test the node if it not visited then we will break the loop and go for it
         */
        do
        {
            n = q.poll();
            s = n.getPlace();
        }while (visited[s.getX()][s.getY()]);

        //mark node as visited
        visited[s.getX()][s.getY()]=true;

        tries++;
        choice = n;
        //return selected node
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
        System.out.println("IT NEED " + getTries() + " Tries to WIN in Bfs");

        return "";
    }
}
