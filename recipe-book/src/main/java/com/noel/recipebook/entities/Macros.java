package com.noel.recipebook.entities;

public class Macros {

    private int calories;

    private int fats;

    private int carbs;

    private int protein;

    public Macros(int calories, int fats, int carbs, int protein) {
        this.calories = calories;
        this.fats = fats;
        this.carbs = carbs;
        this.protein = protein;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    @Override
    public String toString() {
        return "Macros {" +
                "calories=" + calories +
                ", fats=" + fats +
                ", carbs=" + carbs +
                ", protein=" + protein +
                '}';
    }
}
