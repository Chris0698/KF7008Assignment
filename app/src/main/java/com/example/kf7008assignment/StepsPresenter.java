package com.example.kf7008assignment;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class StepsPresenter
{
    private IStepsPresenter iStepsPresenter;
    private int goal;

    public StepsPresenter(IStepsPresenter iStepsPresenter)
    {
        if(iStepsPresenter == null)
        {
            throw new IllegalStateException("Presenter can't be null");
        }

        this.iStepsPresenter = iStepsPresenter;
        goal = 0;
    }

    public void getGoal()
    {
        int stepsGoal = 3000;

        iStepsPresenter.UpdateStepsGoal("Current Steps Goal: " + stepsGoal);
    }

    public void GetStepsForMonth(int month, int year)
    {
        //really  this would go to the data access layer to get the data from a database
        //but for the assignment fake data for all months will be used unless i get round to adding
        //a DB

        int amountAboveTarget = 0;

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 100));
        entries.add(new Entry(2, 50));
        entries.add(new Entry(3, 500));
        entries.add(new Entry(4, 3000));
        entries.add(new Entry(5, 863));
        entries.add(new Entry(6, 3221));
        entries.add(new Entry(7, 50));
        entries.add(new Entry(8, 100));
        entries.add(new Entry(9, 0));
        entries.add(new Entry(10, 1340));
        entries.add(new Entry(11, 986));
        entries.add(new Entry(12, 100));
        entries.add(new Entry(13, 50));
        entries.add(new Entry(14, 500));
        entries.add(new Entry(15, 3000));
        entries.add(new Entry(16, 863));
        entries.add(new Entry(17, 3221));
        entries.add(new Entry(18, 50));
        entries.add(new Entry(19, 100));
        entries.add(new Entry(20, 0));
        entries.add(new Entry(21, 1340));
        entries.add(new Entry(22, 986));
        entries.add(new Entry(23, 100));
        entries.add(new Entry(24, 50));
        entries.add(new Entry(25, 500));
        entries.add(new Entry(26, 3000));
        entries.add(new Entry(27, 863));
        entries.add(new Entry(28, 3221));
        entries.add(new Entry(29, 50));
        entries.add(new Entry(30, 100));

        for(Entry entry : entries)
        {
            if(entry.getY() > goal)
            {
                amountAboveTarget++;
            }

            iStepsPresenter.AddStepsEntry(entry);
        }

        iStepsPresenter.SetCounterGoalAchieved(amountAboveTarget);
    }

    public void SyncConnectedDevice()
    {
        //for the assignment this data is fake
        GetStepsForMonth(0,0);
    }
}
