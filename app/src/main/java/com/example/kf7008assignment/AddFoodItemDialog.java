package com.example.kf7008assignment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddFoodItemDialog extends Dialog
{
    private int calories;

    public AddFoodItemDialog(Activity activity)
    {
        super(activity);
        calories = 0;
    }

    public void ShowDialog(final DailyFoodLogPresenter dailyFoodLogPresenter)
    {
        if(dailyFoodLogPresenter == null)
        {
            throw new IllegalStateException("Daily Food Log Presenter is null in AddFoodItemDialog");
        }

        setContentView(R.layout.alert_add_daily_food);

        final EditText foodNameEditText = findViewById(R.id.alertAddDailyFoodItemFoodNameEditText);
        final EditText foodCaloriesEditText = findViewById(R.id.alertAddDailyFoodItemFoodCaloriesEditText);

        Button backButton = findViewById(R.id.alertAddDailyFoodItemFoodBackButton);
        if(backButton != null)
        {
            backButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    hide();
                }
            });
        }

        Button addButton = findViewById(R.id.alertAddDailyFoodItemAddButton);
        if(addButton != null)
        {
            addButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    String name = foodNameEditText.getText().toString();
                    String caloriesString = foodCaloriesEditText.getText().toString();

                    if(ValidateData(name, caloriesString))
                    {
                        dailyFoodLogPresenter.AddFoodItem(new FoodItem(name, calories));

                        hide();
                    }
                }
            });
        }

        show();
    }

    private boolean ValidateData(String foodName, String caloriesString)
    {
        boolean valid = true;

        if(foodName.length() <= 0)
        {
            new AlertDialog.Builder(getContext())
                    .setTitle("Empty Name")
                    .setMessage("Name can't be empty.")
                    .setPositiveButton(android.R.string.ok, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            valid = false;
        }
        else if(caloriesString.length() <= 0)
        {
            new AlertDialog.Builder(getContext())
                    .setTitle("Empty Calories")
                    .setMessage("Enter a number for Calories.")
                    .setPositiveButton(android.R.string.ok, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            valid = false;
        }
        else if(caloriesString.length() > 0)
        {
            //The text view has a restriction of sort to prevent things like chars being entered
            //but just in case
            try
            {
                calories = Integer.parseInt(caloriesString);
            }
            catch (ClassCastException ex)
            {
                new AlertDialog.Builder(getContext())
                        .setTitle("Invalid Calories")
                        .setMessage("Invalid Entry for Calories.")
                        .setPositiveButton(android.R.string.ok, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                valid = false;
            }

            if(calories < 0)
            {
                new AlertDialog.Builder(getContext())
                        .setTitle("Negative Calories")
                        .setMessage("Calories can't be negative.")
                        .setPositiveButton(android.R.string.ok, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                valid = false;
            }
        }

        return valid;
    }
}
