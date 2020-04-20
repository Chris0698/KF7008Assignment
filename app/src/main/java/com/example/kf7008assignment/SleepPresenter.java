package com.example.kf7008assignment;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class SleepPresenter
{
    private ISleepPresenter iSleepPresenter;

    public SleepPresenter(ISleepPresenter iSleepPresenter) throws Exception
    {
        if(iSleepPresenter == null)
        {
            throw new Exception();
        }

        this.iSleepPresenter = iSleepPresenter;
    }

    public void GetGoal()
    {
        int goal = 0;
        iSleepPresenter.UpdateGoal("Current Sleep Goal: " + goal);
    }

    public void GetSleepHoursForMonth(int month, int year)
    {
        //really  this would go to the data access layer to get the data from a database
        //but for the assignment fake data for all months will be used unless i get round to adding
        //a DB

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
            iSleepPresenter.AddSleepEntry(entry);
        }
    }

    public void SyncConnectedDevice()
    {

    }
}
