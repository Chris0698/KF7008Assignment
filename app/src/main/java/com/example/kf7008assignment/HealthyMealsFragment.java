package com.example.kf7008assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HealthyMealsFragment extends SwipeRefreshFragment implements IHealthyMeals
{
    private HealthyMealsPresenter healthyMealsPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.healthy_meals_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        TextView fragmentHeader = view.findViewById(R.id.fragmentHeading);
        if(fragmentHeader != null)
        {
            fragmentHeader.setText("Healthy Meals");
        }

        try
        {
            healthyMealsPresenter = new HealthyMealsPresenter(this);
        }
        catch (Exception ex){}
    }

    @Override
    public void RefreshUI(@NonNull View view)
    {
        healthyMealsPresenter.GetNewMeals();
    }
}
