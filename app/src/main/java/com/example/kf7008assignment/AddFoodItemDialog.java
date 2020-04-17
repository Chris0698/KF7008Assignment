package com.example.kf7008assignment;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddFoodItemDialog
{
    public void ShowDialog(Activity activity)
    {
        if(activity == null)
        {
            throw new IllegalStateException();
        }

        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.alert_add_daily_food);

        final EditText foodNameEditText = dialog.findViewById(R.id.alertAddDailyFoodItemFoodNameEditText);
        final EditText foodCaloriesEditText = dialog.findViewById(R.id.alertAddDailyFoodItemFoodCaloriesEditText);

        Button backButton = dialog.findViewById(R.id.alertAddDailyFoodItemFoodBackButton);
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

        Button addButton = dialog.findViewById(R.id.alertAddDailyFoodItemAddButton);
        if(addButton != null)
        {
            addButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    //String name = foodNameEditText.getText().toString();
                   // String calories = foodCaloriesEditText.getText().toString();
                }
            });
        }

        dialog.show();
    }
}
