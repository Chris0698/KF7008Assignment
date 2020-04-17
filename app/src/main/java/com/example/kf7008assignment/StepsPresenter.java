package com.example.kf7008assignment;

public class StepsPresenter
{
    private IStepsPresenter iStepsPresenter;

    public StepsPresenter(IStepsPresenter iStepsPresenter)
    {
        if(iStepsPresenter == null)
        {
            throw new IllegalStateException("Presenter can't be null");
        }

        this.iStepsPresenter = iStepsPresenter;
    }

    public void getGoal()
    {
        int stepsGoal = 0;

        iStepsPresenter.UpdateStepsGoal("Current Steps Goal: " + stepsGoal);
    }

    public void SyncConnectedDevice()
    {
        //for the assignment this is blank
    }
}
