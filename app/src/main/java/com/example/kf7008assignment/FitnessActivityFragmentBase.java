package com.example.kf7008assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.Calendar;

//By Activity i mean as in excersie activity, not activity in an android dev world
//ISwipeRefresh implemented here but method is overriden in subclasses
public abstract class FitnessActivityFragmentBase extends Fragment implements ISwipeRefresh
{
    protected LineChart lineChart;
    protected ArrayList<Entry> graphEntries;

    protected TextView currentGoalTextView;
    protected TextView goalCounterReachedTextView;
    protected TextView currentMonthYearTextView;

    protected int month;
    protected int year;

    protected SwipeRefreshLayout swipeRefreshLayout;
    protected View view;

    public abstract void GetData();

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

        //get current mnoth
        year = Calendar.getInstance().get(Calendar.YEAR);

        //get current year
        month = Calendar.getInstance().get(Calendar.MONTH);

        lineChart = view.findViewById(R.id.lineChart);

        currentGoalTextView = view.findViewById(R.id.goalTextView);

        goalCounterReachedTextView = view.findViewById(R.id.timesMonthlyGoalAchievedTextView);

        currentMonthYearTextView = view.findViewById(R.id.currentMonthYearTextView);

        this.view = view;

        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);

        SwipeRefreshLayout();

        Button previousMonthButton = view.findViewById(R.id.fitnessActivityPreviousMonth);
        if(previousMonthButton != null)
        {
            previousMonthButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    month--;
                    if(month < 0)
                    {
                        month = 12;
                    }

                    GetData();
                }
            });
        }

        Button nextMonthButton = view.findViewById(R.id.fitnessActivityNextMonth);
        if(nextMonthButton != null)
        {
            nextMonthButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    month++;
                    if(month > 12)
                    {
                        month = 1;
                    }

                    GetData();
                }
            });
        }
    }
}
