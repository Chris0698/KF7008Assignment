package com.example.kf7008assignment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

public class SleepFragment extends FitnessActivityFragmentBase implements ISleepPresenter
{
    private SleepPresenter sleepPresenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        try
        {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Sleep");

            sleepPresenter = new SleepPresenter(this);

            GetData();
        }
        catch (Exception ex)
        {
            Log.i("TAG", "Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void GetData()
    {
        lineChart.clear();
        graphEntries.clear();

        sleepPresenter.GetGoal(getContext());
        sleepPresenter.GetSleepHoursForMonth(month, year);

        LineDataSet lineDataSet = new LineDataSet(graphEntries, "Sleep hours");
        LineData lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);
        //lineDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        lineDataSet.setValueTextColor(Color.RED);
        lineDataSet.setValueTextSize(10f);
    }

    @Override
    public void UpdateGoal(String text)
    {
        currentGoalTextView.setText(text);
    }

    @Override
    public void AddSleepEntry(Entry entry)
    {
        graphEntries.add(entry);
    }

    @Override
    public void SetCounterGoalAchieved(int counter)
    {
        goalCounterReachedTextView.setText("Number of times goal achieved this month: " + counter);
    }

    @Override
    public void SwipeRefreshLayout()
    {
        if(swipeRefreshLayout != null)
        {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
            {
                @Override
                public void onRefresh()
                {
                    GetData();
                    swipeRefreshLayout.setRefreshing(false);
                }
            });
        }
        else
        {
            Log.i("TAG", "No Swipe refresh :(");
        }
    }

    @Override
    public void SetMonthAndYearTextView(String text)
    {
        currentMonthYearTextView.setText(text);
    }
}
