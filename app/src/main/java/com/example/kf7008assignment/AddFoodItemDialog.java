package com.example.kf7008assignment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddFoodItemDialog extends Dialog
{
    public AddFoodItemDialog(Activity activity)
    {
        super(activity);
    }

    public void ShowDialog(final DailyFoodLogPresenter dailyFoodLogPresenter)
    {
        if(dailyFoodLogPresenter == null)
        {
            throw new IllegalStateException("Daily Food Log Fragment is null in AddFoodItemDialog");
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
                    int cals = 0;

                    String name = foodNameEditText.getText().toString();
                    String calories = foodCaloriesEditText.getText().toString();

                    if(calories.length() > 0)
                    {
                        cals = Integer.parseInt(calories);
                    }

                    if(name.length() > 0)
                    {
                        dailyFoodLogPresenter.AddFoodItem(new FoodItem(name, cals));
                        hide();
                    }
                    else
                    {
                        new AlertDialog.Builder(getContext())
                                .setTitle("Empty Name")
                                .setMessage("Name can't be empty")
                                .setPositiveButton(android.R.string.ok, null)
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    }
                }
            });
        }

        show();
    }
}
