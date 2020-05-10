package com.example.kf7008assignment;

public interface IDailyFoodLogPresenter
{
    void AddFoodItem(FoodItem foodItem);

    void SetCaloriesTextView(String text);

    void RemoveFoodItem(FoodItem foodItem);
}
