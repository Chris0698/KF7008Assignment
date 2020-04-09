package com.example.kf7008assignment;

public class HealthyMealsPresenter
{
    private IHealthyMealsPresenter iHealthyMealsPresenter;

    public HealthyMealsPresenter(IHealthyMealsPresenter iHealthyMealsPresenter) throws Exception
    {
        if(iHealthyMealsPresenter == null)
        {
            throw new Exception();
        }

        this.iHealthyMealsPresenter = iHealthyMealsPresenter;
    }

    public void GetNewMeals()
    {
        //for the assignment this method is blank, but in real use
        //new meals would be downloaded from a web source from this method

        FoodItem foodItem = new FoodItem("Pizza", "A pizza", 100);
        iHealthyMealsPresenter.AddFoodItem(foodItem);
    }
}
