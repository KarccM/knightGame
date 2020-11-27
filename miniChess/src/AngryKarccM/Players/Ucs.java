package AngryKarccM.Players;

import AngryKarccM.Arena.Square;
import AngryKarccM.Default;
import AngryKarccM.Engine.Engine;
import AngryKarccM.Engine.Node;
import AngryKarccM.ROCKS.Knight;

import java.util.*;

public class Ucs extends Player {
    /**
     * UCS Algorithm
     * Priority Queue store ranking of cell
     * hash table key also store ranking of cell , value has node that we selected to move
     * last Choice we store last choice for calculate perv value + current value
     * visited array we used for stop looping inside graph
     * rocks store algorithm rocks :D
     **/
    Queue<Integer> q = new PriorityQueue();
    HashMap<Integer , Node> choice = new HashMap<>();
    Node last_Choice;
    boolean [] [] visited = new boolean[Default.tableSizeX][Default.tableSizeY];
    private ArrayList rocks;

    public Ucs(){
        last_Choice = new Node();
    }


    @Override
    public Node makeAction(ArrayList squares) {

        /*
         * INIT Ranking for every node we have
         * ranking mode depend on distance between current and goal node
         * ranking func in Engine Class
         * */
        for(Object o : squares){
            ((Node)o).setValue(Engine.getRank((Node) o));
        }
        /*
         * add current ranking value to queue then add node and it's rank value to hash
         */
        for (Object o :squares) {
            q.add(((Node)o).getValue());
            choice.put(((Node)o).getValue() , (Node) o);
        }

        //temp node and square
        Square s;
        Node n;
        do{
            //Get first element in queue
            int index = q.poll();
            //get node for hash
            n = choice.get(index);

            //print how value increase
            System.out.println("Current value "+n.getValue() + " OLD " +  last_Choice.getValue() + " RES : "+n.getValue() + last_Choice.getValue());


            //calculate new rank value ( current + path value )
            n.setValue(n.getValue() + last_Choice.getValue());
            s = n.getPlace();
        }while(visited[s.getX()][s.getY()]);
        //mark current node as visited for stop looping
        visited[s.getX()][s.getY()] = true;
        last_Choice = n;
        //return selected node
        return n;

    }

    @Override
    public List getRocks() {
        return rocks;
    }

    @Override
    public int getTries() {
        return 0;
    }

    @Override
    public void setRocks(List rocks) {
        this.rocks = (ArrayList) rocks;
    }

    @Override
    public String toString() {
        Knight k = (Knight) rocks.get(0);
        System.out.println( "Cost : " + k.getNode().getValue());
        return "";
    }
}
