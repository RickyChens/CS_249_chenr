package edu.chenr.assign02;

public class Superhero {
    private String heroName = "";
    private String realName = "";
    private int height = 0;
    private double weight = 0;

    public int calculateBMI(){
        //BMI Formula ((703 * weight) / (height * height))
        return (int)((703 * weight) / (height * height));
    }
    public String getNameString(){

        return heroName + " (" + realName + ")";
    }
    public String getHeightString(){
        int feet = height/12;
        int inches = height%12;
        return feet + "'-" + inches + "\"";
    }
    public String getWeightString(){
        return weight + " lbs.";
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("NAME: " + getNameString() + "\n");
        sb.append("WEIGHT: " + getWeightString() + "\n");
        sb.append("HEIGHT: " + getHeightString() + "\n");
        sb.append("BMI: " + calculateBMI() + "\n");
        return sb.toString();
    }





    // Setters and Getters
    public String getHeroName(){
        return heroName;
    }
    public String getRealName(){
        return realName;
    }
    public int getHeight(){
        return height;
    }
    public double getWeight(){
        return weight;
    }
    public void setHeroName(String name){
        heroName = name;
    }
    public void setRealName(String name){
        realName = name;
    }
    public void setHeight(int totalInches){
        height = totalInches;
    }
    public void setWeight(double pounds){
        weight = pounds;
    }

}
