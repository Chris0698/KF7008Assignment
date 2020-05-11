package com.example.kf7008assignment;

public class HealthyMealsPresenter
{
    private IHealthyMealsPresenter iHealthyMealsPresenter;

    public HealthyMealsPresenter(IHealthyMealsPresenter iHealthyMealsPresenter) throws Exception
    {
        if(iHealthyMealsPresenter == null)
        {
            throw new Exception("IHealthyMealPresenter can't be null in healthy meals presenter.");
        }

        this.iHealthyMealsPresenter = iHealthyMealsPresenter;
    }

    public void GetNewMeals()
    {
        //for the assignment this method is blank, (with the exception of a fake meal) but in real use
        //new meals would be downloaded from a web source from this method

        FoodItem foodItem = new FoodItem("Pizza", "A pizza. A pizza is made by bread. \n  To prep, words, words, words.", 100);
        FoodItem foodItem1 = new FoodItem("Ice Cream", "Ice cream is an amazing desert.", 20);

        iHealthyMealsPresenter.AddFoodItem(foodItem);
        iHealthyMealsPresenter.AddFoodItem(foodItem1);
    }
}
