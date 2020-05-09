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
        //validation first
        if(steps < 0 || sleep < 0 || calories < 0)
        {
            new AlertDialog.Builder(context)
                    .setTitle("Error")
                    .setMessage("One of the inputs are negative.")
                    .setPositiveButton(android.R.string.ok, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        else if(sleep > 24)
        {
            new AlertDialog.Builder(context)
                    .setTitle("Error")
                    .setMessage("There are only 24 hours in a day")
                    .setPositiveButton(android.R.string.ok, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        else
        {
            MyGoalsDatabaseHandler myGoalsDatabaseHandler = new MyGoalsDatabaseHandler(context);
            boolean result = myGoalsDatabaseHandler.UpdateGoals(steps, sleep, calories);
            if(result)
            {
                new AlertDialog.Builder(context)
                        .setTitle("Goals Updated")
                        .setMessage("Your goals have been updated!")
                        .setPositiveButton(android.R.string.ok, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
            else
            {
                //a very unhelpful error message
                new AlertDialog.Builder(context)
                        .setTitle("An Error Occurred")
                        .setMessage(":(")
                        .setPositiveButton(android.R.string.ok, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        }
    }

    public void GetGoals(Context context)
    {
        //Call to the data access layer
        MyGoalsDatabaseHandler myGoalsDatabaseHandler = new MyGoalsDatabaseHandler(context);
        int steps = myGoalsDatabaseHandler.GetSteps();
        int sleep = myGoalsDatabaseHandler.GetSleep();
        int cals = myGoalsDatabaseHandler.GetCalories();

        //get the goals then set the text fields
        iMyGoalsPresenter.SetCaloriesTextView(cals + "");
        iMyGoalsPresenter.SetSleepTextView(sleep + "");
        iMyGoalsPresenter.SetStepsTextView(steps + "");
    }

    public void GetStatsAchievedCount()
    {
        iMyGoalsPresenter.SetCaloriesGoalTextView("0");
        iMyGoalsPresenter.SetSleepGoalTextView("0");
        iMyGoalsPresenter.SetStepsGoalTextView("0");
    }

}

