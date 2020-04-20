package com.example.kf7008assignment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class CaloriesFragment extends FitnessActivityFragmentBase implements ICaloriesPresenter
{
    private CaloriesPresenter caloriesPresenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        try
        {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Calories");

            caloriesPresenter = new CaloriesPresenter(this);

            GetData();
        }
        catch (Exception ex)
        {

        }
    }

    @Override
    public void RefreshUI(@NonNull View view)
    {
        lineChart.clear();
        graphEntries.clear();
        GetData();
    }

    private void GetData()
    {
        caloriesPresenter.GetGoal();
        caloriesPresenter.GetCaloriesForMonth(month, year);

        LineDataSet lineDataSet = new LineDataSet(graphEntries, "");
        LineData lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);
        //lineDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        lineDataSet.setValueTextColor(Color.BLACK);
        lineDataSet.setValueTextSize(10f);
    }

    @Override
    public void UpdateGoal(String text)
    {
        currentGoalTextView.setText(text);
    }

    @Override
    public void AddCaloriesEntry(Entry entry)
    {
        graphEntries.add(entry);
    }

    @Override
    public void SetCounterGoalAchieved(int counter)
    {
        goalCounterReachedTextView.setText("Number of times goal achieved this month: " + counter);
    }
}
