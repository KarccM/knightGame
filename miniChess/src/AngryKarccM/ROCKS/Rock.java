package AngryKarccM.ROCKS;

import AngryKarccM.Arena.Square;
import AngryKarccM.Engine.Node;

public abstract class Rock {
    protected String name;
    protected String moveType;
    protected Node node;
    public Square getPlace() {
        return node.getPlace();
    }

    //update place off rock
    public void setPlace(Square place) {
        node.setPlace(place);
    }

    //get last position
    public Square getLast_pos() {
        int size = node.getPath().size() - 1;
        if(size >= 1)
            return node.getPath().get(size -1);
        return node.getPath().get(size);
    }

    public Node getNode() {
        return node;
    }

    public abstract void update(Node node);

    @Override
    public String toString() {
        System.out.println(this.node.toString());
        return "";
    }
}