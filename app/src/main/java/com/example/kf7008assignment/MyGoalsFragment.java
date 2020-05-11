package com.example.kf7008assignment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MyGoalsFragment extends Fragment implements IMyGoalsPresenter
{
    private TextView stepsTextView;
    private TextView sleepTextView;
    private TextView caloriesTextView;

    private TextView stepsGoalPlainText;
    private TextView sleepGoalPlainText;
    private TextView caloriesGoalPlainText;

    private MyGoalsPresenter myGoalsPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.my_goals_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        stepsTextView = view.findViewById(R.id.stepsTextView);
        sleepTextView = view.findViewById(R.id.sleepTextView);
        caloriesTextView = view.findViewById(R.id.caloriesTextView);

        sleepGoalPlainText = view.findViewById(R.id.sleepGoalPlaintext);
        stepsGoalPlainText = view.findViewById(R.id.stepsGoalPlainText);
        caloriesGoalPlainText = view.findViewById(R.id.caloriesGoalPlainText);

        Button updateGoalsButton = view.findViewById(R.id.updateGoalsButton);
        if(updateGoalsButton != null)
        {
            updateGoalsButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    try
                    {
                        String steps = stepsTextView.getText().toString();
                        String sleep = sleepTextView.getText().toString();
                        String calories = caloriesTextView.getText().toString();

                        int stepsValue = Integer.parseInt(steps) ;
                        int caloriesValue = Integer.parseInt(calories);
                        int sleepValue = Integer.parseInt(sleep);

                        myGoalsPresenter.UpdateGoals(stepsValue, sleepValue, caloriesValue, getContext());
                    }
                    catch (Exception ex)
                    {
                        new AlertDialog.Builder(getContext())
                                .setTitle("Exception")
                                .setMessage(ex.getMessage())
                                .setPositiveButton(android.R.string.ok, null)
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                        Log.i("TAG", "Exception: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            });
        }

        try
        {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("My Goals");

            myGoalsPresenter = new MyGoalsPresenter(this);

            myGoalsPresenter.GetGoals(getContext());

            myGoalsPresenter.GetStatsAchievedCount();
        }
        catch (Exception ex)
        {
            new AlertDialog.Builder(getContext())
                    .setTitle("Exception")
                    .setMessage(ex.getMessage())
                    .setPositiveButton(android.R.string.ok, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            Log.i("TAG", "Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void SetSleepTextView(String value)
    {
        if(sleepTextView != null)
        {
            sleepTextView.setText(value);
        }
    }

    @Override
    public void SetStepsTextView(String value)
    {
        if(stepsTextView != null)
        {
            stepsTextView.setText(value);
        }
    }

    @Override
    public void SetCaloriesTextView(String value)
    {
        if(caloriesTextView != null)
        {
            caloriesTextView.setText(value);
        }
    }

    @Override
    public void SetStepsGoalTextView(String goalCount)
    {
        if(stepsGoalPlainText != null)
        {
            stepsGoalPlainText.setText("Times step goal achieved: " + goalCount);
        }
    }

    @Override
    public void SetSleepGoalTextView(String goalCount)
    {
        if(sleepGoalPlainText != null)
        {
            sleepGoalPlainText.setText("Times sleep goal achieved: " + goalCount);
        }
    }

    @Override
    public void SetCaloriesGoalTextView(String goalCount)
    {
        if(caloriesGoalPlainText != null)
        {
            caloriesGoalPlainText.setText("Times calories burnt goal achieved: " + goalCount);
        }
    }
}
