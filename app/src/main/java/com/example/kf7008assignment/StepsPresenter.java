package com.example.kf7008assignment;

public class StepsPresenter
{
    private IStepsPresenter iStepsPresenter;

    public StepsPresenter(IStepsPresenter iStepsPresenter) throws Exception
    {
        if(iStepsPresenter == null)
        {
            throw new Exception();
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

    }
}
