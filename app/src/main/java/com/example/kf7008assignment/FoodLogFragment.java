package com.example.kf7008assignment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FoodLogFragment extends Fragment implements IFoodLogPresenter
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
        calendarView = view.findViewById(R.id.calenderView);
        if(calendarView != null)
        {
            calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
            {
                @Override
                public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
                {
                    Log.i("TAG", "DMY: " + dayOfMonth + month + year);

                    DailyFoodLogFragment fragment = new DailyFoodLogFragment();
                    fragment.PopulateValues(dayOfMonth, month, year);
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });
        }

        try
        {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Food Log");

            foodLogPresenter = new FoodLogPresenter(this);
        }
        catch (Exception ex) {}
    }
}
