package com.example.kf7008assignment;

import com.github.mikephil.charting.data.Entry;

public interface ICaloriesPresenter
{
    void UpdateGoal(String text);

    void AddCaloriesEntry(Entry entry);

    void SetCounterGoalAchieved(int counter);

    void SetMonthAndYearTextView(String text);
}
