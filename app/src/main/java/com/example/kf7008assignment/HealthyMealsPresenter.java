package com.example.kf7008assignment;

public class HealthyMealsPresenter
{
    private IHealthyMeals iHealthyMeals;

    public HealthyMealsPresenter(IHealthyMeals iHealthyMeals) throws Exception
    {
        if(iHealthyMeals == null)
        {
            throw new Exception();
        }

        this.iHealthyMeals = iHealthyMeals;
    }

    public void GetNewMeals()
    {
        //for the assignment this method is blank, but in real use
        //new meals would be downloaded from a web source from this method
    }
}
