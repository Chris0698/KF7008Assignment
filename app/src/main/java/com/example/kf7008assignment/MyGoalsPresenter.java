package com.example.kf7008assignment;

import android.app.AlertDialog;
import android.content.Context;

public class MyGoalsPresenter
{
    private IMyGoals iMyGoals;

    public MyGoalsPresenter(IMyGoals iMyGoals) throws Exception
    {
        if(iMyGoals == null)
        {
            throw new Exception();
        }

        this.iMyGoals = iMyGoals;
    }

    public void UpdateGoals(int steps, int sleep, int calories, Context context)
    {
        new AlertDialog.Builder(context)
                .setTitle("Goals Updated")
                .setMessage("Your goals have been updated!")
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void SetGoals()
    {
        //get the goals then set the text fields
        iMyGoals.SetCaloriesTextView("0");
        iMyGoals.SetSleepTextView("0");
        iMyGoals.SetStepsTextView("0");
    }

    public void GetStatsAchievedCount()
    {
        iMyGoals.SetCaloriesGoalTextView("0");
        iMyGoals.SetSleepGoalTextView("0");
        iMyGoals.SetStepsGoalTextView("0");
    }

}

