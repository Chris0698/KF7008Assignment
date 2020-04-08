package com.example.kf7008assignment;

import android.app.AlertDialog;
import android.content.Context;

public class MyGoalsPresenter
{
    private IMyGoalsPresenter iMyGoalsPresenter;

    public MyGoalsPresenter(IMyGoalsPresenter iMyGoalsPresenter) throws Exception
    {
        if(iMyGoalsPresenter == null)
        {
            throw new Exception();
        }

        this.iMyGoalsPresenter = iMyGoalsPresenter;
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
        iMyGoalsPresenter.SetCaloriesTextView("0");
        iMyGoalsPresenter.SetSleepTextView("0");
        iMyGoalsPresenter.SetStepsTextView("0");
    }

    public void GetStatsAchievedCount()
    {
        iMyGoalsPresenter.SetCaloriesGoalTextView("0");
        iMyGoalsPresenter.SetSleepGoalTextView("0");
        iMyGoalsPresenter.SetStepsGoalTextView("0");
    }

}

