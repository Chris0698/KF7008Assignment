package com.example.kf7008assignment;

public class FoodItem
{
    private String name;
    private String description;
    private int calories;

    public FoodItem(String name, String description, int calories)
    {
        this.calories = calories;
        this.description = description;
        this.name = name;
    }

    public FoodItem(String name, int calories)
    {
        this.name = name;
        description = "";
        this.calories = calories;
    }

    public String GetName() {return  name;}

    public String GetDescription() {return description;}

    public int GetCalories() {return  calories;}

}
