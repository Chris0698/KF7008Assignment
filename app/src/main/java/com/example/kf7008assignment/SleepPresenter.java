package com.example.kf7008assignment;

import android.content.Context;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class SleepPresenter
{
    private ISleepPresenter iSleepPresenter;
    private int goal;

    public SleepPresenter(ISleepPresenter iSleepPresenter) throws Exception
    {
        if(iSleepPresenter == null)
        {
            throw new Exception("ISleepPresenter can't be null in sleep presenter.");
        }

        this.iSleepPresenter = iSleepPresenter;
        goal = 0;
    }

    public void GetGoal(Context context)
    {
        MyGoalsDatabaseHandler myGoalsDatabaseHandler = new MyGoalsDatabaseHandler(context);
        goal = myGoalsDatabaseHandler.GetSleep();
        iSleepPresenter.UpdateGoal("Current Sleep Goal: " + goal + " hours.");
    }

    public void GetSleepHoursForMonth(int month, int year)
    {
        //really  this would go to the data access layer to get the data from a database
        //but for the assignment fake data for all months will be used unless i get round to adding
        //a DB

        //Connected Device would also need checked in some way

        int aboveTargetGoalCounter = 0;

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

        //graph entries
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 8));
        entries.add(new Entry(2, 8));
        entries.add(new Entry(3, 7));
        entries.add(new Entry(4, 6));
        entries.add(new Entry(5, 8));
        entries.add(new Entry(6, 7));
        entries.add(new Entry(7, 6));
        entries.add(new Entry(8, 9));
        entries.add(new Entry(9, 12));
        entries.add(new Entry(10, 8));
        entries.add(new Entry(11, 7));
        entries.add(new Entry(12, 9));
        entries.add(new Entry(13, 8));
        entries.add(new Entry(14, 6));
        entries.add(new Entry(15, 4));
        entries.add(new Entry(16, 8));
        entries.add(new Entry(17, 8));
        entries.add(new Entry(18, 8));
        entries.add(new Entry(19, 9));
        entries.add(new Entry(20, 7));
        entries.add(new Entry(21, 8));
        entries.add(new Entry(22, 6));
        entries.add(new Entry(23, 9));
        entries.add(new Entry(24, 10));
        entries.add(new Entry(25, 9));
        entries.add(new Entry(26, 7));
        entries.add(new Entry(27, 7));
        entries.add(new Entry(28, 8));
        entries.add(new Entry(29, 9));
        entries.add(new Entry(30, 10));

        for(Entry entry : entries)
        {
            if(entry.getY() >= goal)
            {
                aboveTargetGoalCounter++;
            }

            iSleepPresenter.AddSleepEntry(entry);
        }

        iSleepPresenter.SetCounterGoalAchieved(aboveTargetGoalCounter);
        iSleepPresenter.SetMonthAndYearTextView(monthString + " " + year);
    }
}
