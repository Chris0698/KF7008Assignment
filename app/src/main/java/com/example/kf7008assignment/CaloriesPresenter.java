package com.example.kf7008assignment;

public class CaloriesPresenter
{
    private ICalories iCalories;

    public CaloriesPresenter(ICalories iCalories) throws Exception
    {
        if(iCalories == null)
        {
            throw new Exception()   ;
        }

        this.iCalories = iCalories;
    }

    public void GetGoal()
    {
        int goal = 0;
        iCalories.UpdateGoal("Current Calories Goal: " + goal);
    }

    public void SyncConnectedDevice()
    {

    }
}
