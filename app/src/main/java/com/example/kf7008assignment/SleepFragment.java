package com.example.kf7008assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SleepFragment extends SwipeRefreshFragment implements ISleep
{
    private SleepPresenter sleepPresenter;

    private TextView goalTextView;

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
        TextView fragmentHeading = view.findViewById(R.id.fragmentHeading);
        if(fragmentHeading != null)
        {
            fragmentHeading.setText("Sleep");
        }

        goalTextView = view.findViewById(R.id.goalTextView);

        try
        {
            sleepPresenter = new SleepPresenter(this);
        }
        catch (Exception ex){}

        sleepPresenter.GetGoal();
    }

    @Override
    public void RefreshUI(@NonNull View view)
    {
        sleepPresenter.GetGoal();
        sleepPresenter.SyncConnectedDevice();
    }

    @Override
    public void UpdateGoal(String text)
    {
        goalTextView.setText(text);
    }
}
