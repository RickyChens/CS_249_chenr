package edu.chenr.assign06;

import edu.chenr.assign04.ScreenBuffer;

public class Skeleton extends Creature{
    public Skeleton() {

    }
    public Skeleton(int row, int col) {
        super(row, col);
    }

    public String toString(){
        return "Skeleton at " + getRow() + "," + getCol();
    }
    public void draw(ScreenBuffer map) {
        map.setPos(getRow(), getCol(), 'S');
    }
}
