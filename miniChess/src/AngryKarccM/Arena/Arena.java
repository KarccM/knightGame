package AngryKarccM.Arena;

import AngryKarccM.Default;
import AngryKarccM.ROCKS.Rock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Arena {
    public static int width , height;
    public static final HashMap<Integer , ArrayList<Integer>> blocked = new HashMap<>();
    private ArrayList<Rock> rocks ;
    private final char [][] arena;
    public Arena(int width, int height){
        Arena.width = width;
        Arena.height = height;
        rocks = new ArrayList<>();
        arena = new char[height][width];
        for (int i = 0 ; i < height ; i++)
            for (int j = 0 ; j < width ; j++)
                arena[i][j] = '0';
        generateBlocked();

    }

    /*
    This Function will generate Blocked Area Random
     */
    private void generateBlocked(){
        Random random = new Random();
        for (int i = 0 ; i < random.nextInt(width); i++){
            int x ;
            blocked.put(x = random.nextInt(height) , new ArrayList<>());
            blocked.get(x).add(random.nextInt(width));
            blocked.get(x).add(random.nextInt(width));
        }
        //Mark Blocked Area By : 'X'
        for (Integer x : blocked.keySet()) {
            for (Integer y : blocked.get(x))
                arena[x][y] = 'X';
        }
    }

    public void print_Arena(){
        for (int i = 0 ; i < height ; i++){
            for (int j = 0 ; j < width ; j++)
                System.out.print(arena[i][j] + " ");
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void update(List rocks){
        this.rocks = (ArrayList<Rock>) rocks;

            for (int i = 0 ; i < height ; i++)
                for (int j = 0 ; j < width ; j++)
                    arena[i][j] = '0';

            for(Rock rock : this.rocks)
                arena[rock.getPlace().x][rock.getPlace().y] = 'H';

            arena[Default.start.x][Default.start.y] = 'S';
            arena[Default.goal.x][Default.goal.y] = 'G';

    }

    public void validateGoal(Square goal){
        if(blocked.get(goal.getX()) != null){
            ArrayList l = blocked.get(goal.getX());
            for (int i = 0 ; i < l.size() ; i ++)
                if (l.get(i).equals(goal.getY())) {
                    l.remove(i);
                    break;
                }
        }
        arena[goal.getX()][goal.getY()] = 'G';
        System.out.println("Validate Complete");
        validateStart(Default.start);
    }
    private void validateStart(Square goal){
        if(blocked.get(goal.getX()) != null){
            ArrayList l = blocked.get(goal.getX());
            for (int i = 0 ; i < l.size() ; i ++)
                if (l.get(i).equals(goal.getY())) {
                    l.remove(i);
                    break;
                }
        }
        arena[goal.getX()][goal.getY()] = 'S';
    }

    public static void printPath(ArrayList path){
        System.out.println("Path of algo :");
        for (Object obj : path){
            obj.toString();
        }
    }

}
