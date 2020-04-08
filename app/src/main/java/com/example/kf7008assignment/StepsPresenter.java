package com.example.kf7008assignment;

import androidx.appcompat.app.AppCompatActivity;

public class StepsPresenter
{
    private ISteps iSteps;

    public StepsPresenter(ISteps iSteps) throws Exception
    {
        if(iSteps == null)
        {
            throw new Exception();
        }

        this.iSteps = iSteps;
    }

    public void getGoal()
    {
        int stepsGoal = 0;

        iSteps.UpdateStepsGoal("Current Steps Goal: " + stepsGoal);
    }

    public void SyncConnectedDevice()
    {

    }
}
