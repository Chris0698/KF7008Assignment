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

public class CaloriesFragment extends SwipeRefreshFragment implements ICaloriesPresenter
{
    private CaloriesPresenter caloriesPresenter;
    private TextView goalTextView;
    private ArrayList<Entry> caloriesEntry;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fitness_activity_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        goalTextView = view.findViewById(R.id.goalTextView);
        LineChart lineChart = view.findViewById(R.id.lineChart);
        caloriesEntry = new ArrayList<>();

        try
        {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Calories");

            caloriesPresenter = new CaloriesPresenter(this);

            caloriesPresenter.GetGoal();

            caloriesPresenter.GetCaloriesForMonth(0 ,0);

            LineDataSet lineDataSet = new LineDataSet(caloriesEntry, "");
            LineData lineData = new LineData(lineDataSet);
            lineChart.setData(lineData);
            //lineDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
            lineDataSet.setValueTextColor(Color.BLACK);
            lineDataSet.setValueTextSize(10f);
        }
        catch (Exception ex)
        {

        }
    }

    @Override
    public void RefreshUI(@NonNull View view)
    {
        caloriesPresenter.GetGoal();
        caloriesPresenter.SyncConnectedDevice();
    }

    @Override
    public void UpdateGoal(String text)
    {
        goalTextView.setText(text);
    }

    @Override
    public void AddCaloriesEntry(Entry entry)
    {
        caloriesEntry.add(entry);
    }
}
