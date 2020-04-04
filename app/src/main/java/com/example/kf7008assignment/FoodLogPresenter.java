package com.example.kf7008assignment;

public class FoodLogPresenter
{
    private IFoodLog iFoodLog;

    public FoodLogPresenter(IFoodLog iFoodLog) throws Exception
    {
        if(iFoodLog == null)
        {
            throw new Exception();
        }

        this.iFoodLog = iFoodLog;
    }
}
