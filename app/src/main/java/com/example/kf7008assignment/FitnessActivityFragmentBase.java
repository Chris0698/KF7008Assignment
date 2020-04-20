package com.example.kf7008assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

//By Activity i mean as in excersie activity, not activity in an android dev world
public abstract class FitnessActivityFragmentBase extends SwipeRefreshFragment
{
    protected LineChart lineChart;
    protected ArrayList<Entry> graphEntries;

    protected TextView currentGoalTextView;
    protected TextView goalCounterReachedTextView;

    protected int month;
    protected int year;

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

        graphEntries = new ArrayList<>();

        lineChart = view.findViewById(R.id.lineChart);

        currentGoalTextView = view.findViewById(R.id.goalTextView);

        goalCounterReachedTextView = view.findViewById(R.id.timesMonthlyGoalAchievedTextView);
    }
}
