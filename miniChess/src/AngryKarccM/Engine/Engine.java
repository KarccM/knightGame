package AngryKarccM.Engine;

import AngryKarccM.Arena.Arena;
import AngryKarccM.Arena.Square;
import AngryKarccM.Default;
import AngryKarccM.ROCKS.Knight;
import AngryKarccM.ROCKS.Rock;

import java.util.ArrayList;
import java.util.List;

public class Engine {
    private final Square goal;

    public Engine(Square goal) {
        this.goal = goal;
    }

    public ArrayList getNewPlaces(Rock rock){
        if(rock instanceof Knight){
            return generateHorsePlace(rock);
        }
        return null;
    }





    /*
    NOTE FOR ME :D
    + this method should change depend on player mean ( if player blind (DFS , BFS ) ill return all possible nodes
    , in informal player (a *) ill not return all possible )
     */

    //this method will return nodes that i can go for it from my position
    private ArrayList generateHorsePlace(Rock rock){
        ArrayList<Node> nodes = new ArrayList<>();

        int xRock = rock.getPlace().getX();
        int yRock = rock.getPlace().getY();

        int [] xs  = {2 , 2 , -2 , -2 , 1 , -1 , 1 , -1};
        int [] ys  = {1 , -1 , 1 , -1 , 2 , 2 , -2 , -2};

        // Check if each possible move is valid or not
        for (int i = 0; i < 8; i++) {

            // Position of knight after move
            int x = xRock + xs[i];
            int y = yRock + ys[i];

            boolean flag = true;
            // count valid moves
            if (x >= 0 && y >= 0 && x < Arena.width && y < Arena.height) {
               // Make Sure Square not blocked
                if(Arena.blocked.get(x) != null)
                    for (Integer j : Arena.blocked.get(x))
                        if (j == y) flag = false;
                        //if not blocked then add to valid square
                        if (flag){
                            nodes.add(new Node(new Square(x,y) , new ArrayList(rock.getNode().path)));
                        }
            }
        }
        return nodes;
    }
    //Check if Player Win or not
    public void checker(List rocks){
        for (Object r : rocks){
            if (((Rock) r).getPlace().getX() == goal.getX() && ((Rock) r).getPlace().getY() == goal.getY()) {
                State.finish = true;
                System.out.println(r.toString());
                break;
            }
        }
    }


    //Rank Method
    public static int getRank(Node node){
        return (node.getPlace().getX() - Default.goal.getX()) + (node.getPlace().getY() - Default.goal.getY());
    }
    /*
    Add method for validate the road
     */


}
