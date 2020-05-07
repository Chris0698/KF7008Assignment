package com.example.kf7008assignment;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class CaloriesPresenter
{
    private ICaloriesPresenter iCaloriesPresenter;
    private int goal;

    public CaloriesPresenter(ICaloriesPresenter iCaloriesPresenter)
    {
        if(iCaloriesPresenter == null)
        {
            throw new IllegalStateException("Calories presenter can't be null");
        }

        this.iCaloriesPresenter = iCaloriesPresenter;
    }

    public void GetGoal()
    {
        goal = 500;
        iCaloriesPresenter.UpdateGoal("Current Calories Goal: " + goal);
    }

    public void GetCaloriesForMonth(int month, int year)
    {
        //really  this would go to the data access layer to get the data from a database
        //but for the assignment fake data for all months will be used unless i get round to adding
        //a DB

        int amountAboveGoalCounter = 0;
        String monthString = "";

        switch (month)
        {
            case 1:
                monthString = "Jan";
                break;
            case 2:
                monthString = "Feb";
                break;
            case 3:
                monthString = "Mar";
                break;
            case 4:
                monthString = "Apr";
                break;
            case 5:
                monthString = "May";
                break;
            case 6:
                monthString = "Jun";
                break;
            case 7:
                monthString = "Jul";
                break;
            case 8:
                monthString = "Aug";
                break;
            case 9:
                monthString = "Sep";
                break;
            case 10:
                monthString = "Oct";
                break;
            case 11:
                monthString = "Nov";
                break;
            case 12:
                monthString = "Dec";
                break;
            default:
                break;
        }

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 100));
        entries.add(new Entry(2, 50));
        entries.add(new Entry(3, 500));
        entries.add(new Entry(4, 3000));
        entries.add(new Entry(5, 863));
        entries.add(new Entry(6, 3221));
        entries.add(new Entry(7, 50));
        entries.add(new Entry(8, 100));
        entries.add(new Entry(9, 230));
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
        entries.add(new Entry(20, 423));
        entries.add(new Entry(21, 1340));
        entries.add(new Entry(22, 986));
        entries.add(new Entry(23, 100));
        entries.add(new Entry(24, 50));
        entries.add(new Entry(25, 500));
        entries.add(new Entry(26, 3000));
        entries.add(new Entry(27, 863));
        entries.add(new Entry(28, 3221));
        entries.add(new Entry(29, 6456));
        entries.add(new Entry(30, 100));

        for(Entry entry : entries)
        {
            if(entry.getY() >= goal)
            {
                amountAboveGoalCounter++;
            }

            iCaloriesPresenter.AddCaloriesEntry(entry);
        }

        iCaloriesPresenter.SetCounterGoalAchieved(amountAboveGoalCounter);
        iCaloriesPresenter.SetMonthAndYearTextView(monthString + " " + year);
    }

    public void SyncConnectedDevice()
    {
        GetCaloriesForMonth(0,0);
    }
}
