package com.example.kf7008assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StepsFragment extends SwipeRefreshFragment implements ISteps
{
    private StepsPresenter stepsPresenter;

    private TextView goalsTextView;

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
            fragmentHeading.setText("Steps");
        }

        try
        {
            stepsPresenter = new StepsPresenter(this);
        }
        catch (Exception ex){}

        goalsTextView = view.findViewById(R.id.goalTextView);

        stepsPresenter.getGoal();
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
}
