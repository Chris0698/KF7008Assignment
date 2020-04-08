package com.example.kf7008assignment;

public class CaloriesPresenter
{
    private ICaloriesPresenter iCaloriesPresenter;

    public CaloriesPresenter(ICaloriesPresenter iCaloriesPresenter) throws Exception
    {
        if(iCaloriesPresenter == null)
        {
            throw new Exception()   ;
        }

        this.iCaloriesPresenter = iCaloriesPresenter;
    }

    public void GetGoal()
    {
        int goal = 0;
        iCaloriesPresenter.UpdateGoal("Current Calories Goal: " + goal);
    }

    public void SyncConnectedDevice()
    {

    }
}
