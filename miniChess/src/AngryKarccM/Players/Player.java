package AngryKarccM.Players;
import AngryKarccM.Engine.Node;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    public abstract Node makeAction(ArrayList squares);

    public abstract List getRocks();

    public abstract int getTries();
    public abstract void setRocks(List rocks);
}