package com.example.kf7008assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.util.Calendar;

public class DailyFoodLogFragment extends Fragment
{
    private int day;
    private int month;
    private int year;

    private TextView totalCaloriesTextView;
    private ListView foodList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.daily_food_log_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Food Log");

        totalCaloriesTextView = view.findViewById(R.id.foodLogTotalCaloriesTextView);
        foodList = view.findViewById(R.id.foodLogFoodList);

        TextView foodLogDateTextView = view.findViewById(R.id.foodLogDateTextView);
        if(foodLogDateTextView != null)
        {
            foodLogDateTextView.setText("Food Log for: ");
        }
    }

    public void PopulateValues(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
