package edu.chenr.assign04;

public class ScreenBuffer {
    private char[][] matrix;
    private int rowCnt;
    private int colCnt;
    private char fillChar;
    public ScreenBuffer(int rowCnt, int colCnt, char fillChar){
        matrix = new char[rowCnt][colCnt];
        for (int r = 0; r < rowCnt; r++){
            for (int c = 0; c < colCnt; c++){
                matrix[r][c] = fillChar;
            }
        }

        this.fillChar = fillChar;
        this.rowCnt = rowCnt;
        this.colCnt = colCnt;
    }

    public void clear(){
        for (int r = 0; r < rowCnt; r++){
            for (int c = 0; c < colCnt; c++){
                matrix[r][c] = fillChar;
            }
        }
    }

    public int getRowCnt(){
        return rowCnt;
    }
    public int getColCnt(){
        return colCnt;
    }

    public boolean isValidPosition(int row, int col) {
        return row < rowCnt && col < colCnt && row >= 0 && col >= 0;
    }

    public char getPos(int row, int col) {
        if (isValidPosition(row, col)){
            return matrix[row][col];
        } else {
            return ' ';
        }
    }

    public boolean setPos(int row, int col, char c) {
        if (isValidPosition(row, col)){
            matrix[row][col] = c;
            return true;
        }
        return false;
    }

    public String toString(){
        return rowCnt + " x " + colCnt + " ScreenBuffer (default: " + fillChar + ")";
    }

    public String getDisplayString(){
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < rowCnt; r++){
            for (int c = 0; c < colCnt; c++){
                sb.append(matrix[r][c]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}

