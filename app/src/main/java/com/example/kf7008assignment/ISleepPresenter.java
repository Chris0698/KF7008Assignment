package com.example.kf7008assignment;

import com.github.mikephil.charting.data.Entry;

public interface ISleepPresenter
{
    void UpdateGoal(String text);

    void AddSleepEntry(Entry entry);

    void SetCounterGoalAchieved(int counter);

    void SetMonthAndYearTextView(String text);
}
