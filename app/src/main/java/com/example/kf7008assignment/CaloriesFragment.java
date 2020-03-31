package com.example.kf7008assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CaloriesFragment extends SwipeRefreshFragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.calories_fragments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        TextView fragmentHeading = view.findViewById(R.id.fragmentHeading);
        if(fragmentHeading != null)
        {
            fragmentHeading.setText("Calories");
        }
    }

    @Override
    public void RefreshUI(@NonNull View view)
    {

    }
}
