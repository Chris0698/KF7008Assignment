package com.example.kf7008assignment;

public class DailyFoodLogPresenter
{
    private IDailyFoodLogPresenter iDailyFoodLogPresenter;

    public DailyFoodLogPresenter(IDailyFoodLogPresenter iDailyFoodLogPresenter)
    {
        if(iDailyFoodLogPresenter == null)
        {
            throw new IllegalStateException();
        }

        this.iDailyFoodLogPresenter = iDailyFoodLogPresenter;
    }

    public void GetFoodItem()
    {
        //recorded food is gotten here

        iDailyFoodLogPresenter.AddFoodItem();
    }
}
