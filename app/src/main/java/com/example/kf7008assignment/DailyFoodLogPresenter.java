package com.example.kf7008assignment;

import android.app.Activity;

import java.util.ArrayList;

public class DailyFoodLogPresenter
{
    private IDailyFoodLogPresenter iDailyFoodLogPresenter;
    private int calories;
    private ArrayList<FoodItem> foodItems;

    public DailyFoodLogPresenter(IDailyFoodLogPresenter iDailyFoodLogPresenter)
    {
        if(iDailyFoodLogPresenter == null)
        {
            throw new IllegalStateException("Presenter can't be null");
        }

        this.iDailyFoodLogPresenter = iDailyFoodLogPresenter;
        calories = 0;
    }

    /**
     * Recorded food is collected here
     */
    public void GetFoodItems(int day, int month, int year)
    {
        if(day < 0 || month < 0 || year < 0)
        {
            throw new IllegalStateException("Day, Month or Year is negative");
        }

        boolean recordFound = true;    //would call to the DAL to get if a record exists first
        if(recordFound)
        {
            //techincally this would be populated from the DAL, with the entire list returned
            foodItems = null;

            //test
            foodItems = new ArrayList<>();
            foodItems.add(new FoodItem("Test Food", 30));
            foodItems.add(new FoodItem("Test Food 2", 100));

            for (FoodItem foodItem: foodItems)
            {
                calories = calories + foodItem.GetCalories();
                iDailyFoodLogPresenter.AddFoodItem(foodItem);
            }

            iDailyFoodLogPresenter.SetCaloriesTextView("Total Calories: " + calories);
        }
    }

    public void RemoveItem(final int position)
    {
        FoodItem item = foodItems.get(position);
        foodItems.remove(item);
        calories = calories - item.GetCalories();
        iDailyFoodLogPresenter.RemoveFoodItem(item);
        iDailyFoodLogPresenter.SetCaloriesTextView("Total Calories: " + calories);
    }

    public void AddFoodItemButtonClick(Activity activity)
    {
        AddFoodItemDialog addFoodItemDialog = new AddFoodItemDialog(activity);
        addFoodItemDialog.ShowDialog(this);
    }

    /**
     * Called by the AddFoodItemDialog
     */
    public void AddFoodItem(FoodItem foodItem)
    {
        foodItems.add(foodItem);
        calories = calories + foodItem.GetCalories();

        iDailyFoodLogPresenter.SetCaloriesTextView("Total Calories: " + calories);
        iDailyFoodLogPresenter.AddFoodItem(foodItem);
    }
}
