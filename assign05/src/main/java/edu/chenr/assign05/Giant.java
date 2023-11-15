package edu.chenr.assign05;

public class Giant {
    private String name = "";
    public Giant(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
