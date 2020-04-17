package com.example.kf7008assignment;

public class DailyFoodLogPresenter
{
    private IDailyFoodLogPresenter iDailyFoodLogPresenter;

    public DailyFoodLogPresenter(IDailyFoodLogPresenter iDailyFoodLogPresenter)
    {
        if(iDailyFoodLogPresenter == null)
        {
            throw new IllegalStateException("Presenter can't be null");
        }

        this.iDailyFoodLogPresenter = iDailyFoodLogPresenter;
    }

    public void GetFoodItem()
    {
        //recorded food is gotten here
        boolean recordFound = false;
        if(recordFound)
        {
            iDailyFoodLogPresenter.AddFoodItem(new FoodItem("Food", "Food", 0));
        }
    }
}
