package edu.chenr.assign03;

public class Narrator {
    private String[] lines;
    private char boundaryChar;

    //Constructor
    public Narrator(String[] lines, char boundaryChar){
        this.boundaryChar = boundaryChar;
        setLines(lines);
    }

    //Setters and Getters
    public char getBoundaryChar(){
        return boundaryChar;
    }
    public String getLines(){
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line).append("\n");
        }

        return sb.toString();
    }
    public void setBoundaryChar(char boundaryChar){
        this.boundaryChar = boundaryChar;
    }
    public void setLines(String[] lines){
        this.lines = new String[lines.length];
        for (int i = 0; i < lines.length; i++){
            this.lines[i] = lines[i];
        }
    }



    public String generateBoundaryLine(){

        StringBuilder sb = new StringBuilder();
        sb.append((Character.toString(boundaryChar)).repeat(50));
        sb.append("\n");
        return sb.toString();
    }
    public String generateCenteredLine(String text){
        int firstSpace = (48-text.length()) / 2;
        int secondSpace = (48-text.length()) - firstSpace;
        StringBuilder sb = new StringBuilder();

        sb.append(boundaryChar);
        sb.append(" ".repeat(firstSpace));
        sb.append(text);
        sb.append(" ".repeat(secondSpace));
        sb.append(boundaryChar);
        sb.append("\n");

        return sb.toString();
    }




    public String toString(){
        int lineCount = 0;
        int linesLeft = lines.length;
        int extraLines = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lines.length; i+=4){
            sb.append(generateBoundaryLine());
            sb.append(generateCenteredLine(""));


            linesLeft = lines.length - i;

            //uses linesLeft to create the amount of whitespace padding needed
            if (linesLeft < 4) {
                lineCount = linesLeft;
                extraLines = 4 - linesLeft;
            } else {
                lineCount = 4;
                extraLines = 0;
            }

            //Appends lines
            for (int j = 0; j < lineCount; j++){
                sb.append(generateCenteredLine(lines[i + j]));
            }
            //Appends whitespace
            for (int j = 0; j < extraLines; j++){
                sb.append(generateCenteredLine(""));
            }

            sb.append(generateCenteredLine(""));
            sb.append(generateBoundaryLine());
        }

        return sb.toString();
    }
}

