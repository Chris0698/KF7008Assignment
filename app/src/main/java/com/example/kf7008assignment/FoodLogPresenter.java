package com.example.kf7008assignment;

public class FoodLogPresenter
{
    private IFoodLogPresenter iFoodLogPresenter;

    public FoodLogPresenter(IFoodLogPresenter iFoodLogPresenter) throws Exception
    {
        if(iFoodLogPresenter == null)
        {
            throw new Exception();
        }

        this.iFoodLogPresenter = iFoodLogPresenter;
    }
}
