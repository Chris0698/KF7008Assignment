package com.example.kf7008assignment;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectedHealthyMealDialog
{
    public void ShowDialog(Activity activity, FoodItem foodItem)
    {
        if(foodItem == null)
        {
            throw new IllegalStateException();
        }

        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.selected_healthy_meal);

        TextView headingTitle = dialog.findViewById(R.id.selectedHealthyMealHeading);
        if(headingTitle != null)
        {
            headingTitle.setText(foodItem.GetName());
        }

        TextView caloriesText = dialog.findViewById(R.id.selectedHealthyMealCaloriesText);
        if(caloriesText != null)
        {
            caloriesText.setText("Calories: " + foodItem.GetCalories());
        }

        TextView descriptionText = dialog.findViewById(R.id.selectedHealthyMealDescriptionText);
        if(descriptionText != null)
        {
            descriptionText.setText(foodItem.GetDescription());
        }

        Button backButton = dialog.findViewById(R.id.selectedHealthyMealBackButton);
        if(backButton != null)
        {
            backButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    dialog.hide();
                }
            });
        }

        dialog.show();
    }
}
