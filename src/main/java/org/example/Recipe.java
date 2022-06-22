package org.example;

import java.util.ArrayList;

public class Recipe {
   ArrayList<FoodItem> ingredients= new ArrayList<>();
   String method;
   int portions;
   int minutes;

    public Recipe(ArrayList<FoodItem> ingredients, String method, int portions, int minutes) {
        this.ingredients = ingredients;
        this.method = method;
        this.portions = portions;
        this.minutes = minutes;
    }

    public ArrayList<FoodItem> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<FoodItem> ingredients) {
        this.ingredients = ingredients;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }



}
