package edu.chenr.assign04;

public class Box {
    private int sr, sc, er, ec;
    private boolean filled;
    private char drawChar;
    public Box(int sr, int sc, int er, int ec, boolean filled, char drawChar) {
        this.sr = sr;
        this.sc = sc;
        this.er = er;
        this.ec = ec;
        this.filled = filled;
        this.drawChar = drawChar;
    }

    public String toString(){
        if (filled){
            return "Filled Box from (" + sr + "," + sc + ") to (" + er + "," + ec + ") with char \'" + drawChar + "\'";
        } else {
            return "Box from (" + sr + "," + sc + ") to (" + er + "," + ec + ") with char \'" + drawChar + "\'";
        }
    }

    public void draw(ScreenBuffer s){
        if (filled){
            for (int r = sr; r <= er; r++){
                for (int c = sc; c <= ec; c++){
                    s.setPos(r, c, drawChar);
                }
            }
        } else {
            for (int r = sr; r <= er; r++){
                s.setPos(r, sc, drawChar);
                s.setPos(r, ec, drawChar);
            }
            for (int c = sc; c <= ec; c++){
                s.setPos(sr, c, drawChar);
                s.setPos(er, c, drawChar);
            }
        }
    }

}

