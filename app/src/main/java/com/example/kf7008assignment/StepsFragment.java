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
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StepsFragment extends SwipeRefreshFragment implements IStepsPresenter
{
    private StepsPresenter stepsPresenter;
    private TextView goalsTextView;
    private ArrayList<Entry> stepsEntry;

    private int month;
    private int year;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.steps_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        goalsTextView = view.findViewById(R.id.goalTextView);
        LineChart lineChart = view.findViewById(R.id.lineChart);

        stepsEntry = new ArrayList<>();

        try
        {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Steps");

            stepsPresenter = new StepsPresenter(this);

            stepsPresenter.getGoal();

            stepsPresenter.GetStepsForMonth(month, year);

            LineDataSet lineDataSet = new LineDataSet(stepsEntry, "");
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
        stepsPresenter.getGoal();
        stepsPresenter.SyncConnectedDevice();
    }

    @Override
    public void UpdateStepsGoal(String text)
    {
        goalsTextView.setText(text);
    }

    @Override
    public void AddStepsEntry(Entry entry)
    {
        stepsEntry.add(entry);
    }
}
