package AngryKarccM;


import AngryKarccM.Arena.Arena;
import AngryKarccM.Engine.Game;
import AngryKarccM.Engine.Node;
import AngryKarccM.Engine.State;
import AngryKarccM.Players.Bfs;
import AngryKarccM.Players.Dfs;
import AngryKarccM.Players.Ucs;
import AngryKarccM.ROCKS.Knight;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
/*
    NOTE : DON'T VISIT GOAL , VALID , BLOCKED CAUSE IT'S UNDER MAINTENANCE XD
 */
        Bfs b = new Bfs();
        Dfs d = new Dfs();
        new Game(b).run();
        State.finish = false;
        new Game(d).run();

        System.out.println(b.toString());
        System.out.println(d.toString());
//
        State.finish = false;
        Ucs u = new Ucs();
        new Game(u).run();
        u.toString();
    }
}
