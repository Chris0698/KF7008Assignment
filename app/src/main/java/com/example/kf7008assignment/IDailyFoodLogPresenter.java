package com.example.kf7008assignment;

public interface IDailyFoodLogPresenter
{
    void AddFoodItem(FoodItem foodItem);

    //should had taken a string arguement, but with adding food taking place in the presenter
    //then food being removed in the UI class, this was the best i could do here
    void SetCaloriesTextView(int cals);
}
