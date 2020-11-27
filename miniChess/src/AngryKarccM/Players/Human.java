package AngryKarccM.Players;

import AngryKarccM.Arena.Arena;
import AngryKarccM.Arena.Square;
import AngryKarccM.Engine.Node;
import AngryKarccM.ROCKS.Knight;
import AngryKarccM.ROCKS.Rock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Human extends Player{
    private List rocks ;
    private int tries=0;
    public Human(List rocks) {
        this.rocks = rocks;
        //put knight in right place + Catch Exception
        System.out.println("Enter Knight Place : ( X , Y ) ");
        Scanner scanner = new Scanner(System.in);
        ((Rock)rocks.get(0)).setPlace(new Square(scanner.nextInt() % Arena.width , scanner.nextInt() % Arena.height));
    }
    public Human(){
    }

    public Node makeAction(ArrayList squares){

        // print suggestion
        for (int i = 0 ; i < squares.size() ; i++){
            System.out.print("put " + (i+1) + " ( ");
            System.out.println(squares.get(i).toString() + " )");
        }

        System.out.println("Enter Ur Next Movement Square :D ");
        Scanner scanner = new Scanner(System.in);

        tries = 0;
        return new Node((Node) squares.get(scanner.nextInt() - 1), ((Knight)rocks.get(0)).getNode().getPath());
    }
    public List getRocks() {
        return rocks;
    }

    @Override
    public int getTries() {
        return tries;
    }

    @Override
    public void setRocks(List rocks) {
        this.rocks = (ArrayList) rocks;
    }
}
