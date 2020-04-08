package com.example.kf7008assignment;

public class SleepPresenter
{
    private ISleepPresenter iSleepPresenter;

    public SleepPresenter(ISleepPresenter iSleepPresenter) throws Exception
    {
        if(iSleepPresenter == null)
        {
            throw new Exception();
        }

        this.iSleepPresenter = iSleepPresenter;
    }

    public void GetGoal()
    {
        int goal = 0;
        iSleepPresenter.UpdateGoal("Current Sleep Goal: " + goal);
    }

    public void SyncConnectedDevice()
    {

    }
}
