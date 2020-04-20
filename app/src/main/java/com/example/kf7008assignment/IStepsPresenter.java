package com.example.kf7008assignment;

import com.github.mikephil.charting.data.Entry;

public interface IStepsPresenter
{
    void UpdateStepsGoal(String text);

    void AddStepsEntry(Entry entry);

    void SetCounterGoalAchieved(int counter);
}
