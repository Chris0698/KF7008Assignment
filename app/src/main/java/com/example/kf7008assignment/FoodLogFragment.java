package com.example.kf7008assignment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FoodLogFragment extends Fragment implements IFoodLog
{
    private CalendarView calendarView;

    private FoodLogPresenter foodLogPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.food_log_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        TextView fragmentHeader = view.findViewById(R.id.fragmentHeading);
        if(fragmentHeader != null)
        {
            fragmentHeader.setText("Food Log");
        }

        try
        {
            foodLogPresenter = new FoodLogPresenter(this);
        }
        catch (Exception ex) {}

        calendarView = view.findViewById(R.id.calenderView);
        if(calendarView != null)
        {
            calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
            {
                @Override
                public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
                {
                    Log.i("TAG", "DMY: " + dayOfMonth + month + year);
                }
            });
        }
    }
}
