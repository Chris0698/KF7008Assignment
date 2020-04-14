package com.example.kf7008assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class DailyFoodLogFragment extends Fragment implements IDailyFoodLogPresenter
{
    private int day;
    private int month;
    private int year;

    private TextView totalCaloriesTextView;
    private ListView foodList;

    private DailyFoodLogPresenter dailyFoodLogPresenter;

    private ArrayList<FoodItem> foodItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.daily_food_log_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        totalCaloriesTextView = view.findViewById(R.id.foodLogTotalCaloriesTextView);
        foodList = view.findViewById(R.id.foodLogFoodList);
        foodItems = new ArrayList<>();

        TextView foodLogDateTextView = view.findViewById(R.id.foodLogDateTextView);
        if(foodLogDateTextView != null)
        {
            foodLogDateTextView.setText("Food Log for: ");
        }

        Button backButton = view.findViewById(R.id.foodLogBackButton);
        if(backButton != null)
        {
            backButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, new FoodLogFragment());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });
        }

        Button addFoodButton = view.findViewById(R.id.foodLogBackButton);
        if(addFoodButton != null)
        {
            addFoodButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {

                }
            });
        }

        int calories = 0;
        for(FoodItem item : foodItems)
        {
            calories = item.GetCalories();
        }
        totalCaloriesTextView.setText("Total Calories: " + calories);

        try
        {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Food Log");

            dailyFoodLogPresenter = new DailyFoodLogPresenter(this);

            dailyFoodLogPresenter.GetFoodItem();
        }
        catch (Exception ex)
        {

        }
    }

    public void PopulateValues(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public void AddFoodItem()
    {

    }
}
