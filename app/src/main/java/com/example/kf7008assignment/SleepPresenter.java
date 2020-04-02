package com.example.kf7008assignment;

public class SleepPresenter
{
    private ISleep iSleep;

    public SleepPresenter(ISleep iSleep) throws Exception
    {
        if(iSleep == null)
        {
            throw new Exception();
        }

        this.iSleep = iSleep;
    }

    public void UpdateGoal()
    {
        int goal = 0;
        iSleep.UpdateGoal("Current Sleep Goal" + goal);
    }

    public void SyncConnectedDevice()
    {

    }
}
