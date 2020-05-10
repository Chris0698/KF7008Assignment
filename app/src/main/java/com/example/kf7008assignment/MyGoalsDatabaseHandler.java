package com.example.kf7008assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MyGoalsDatabaseHandler extends DatabaseHandlerBase
{
    public MyGoalsDatabaseHandler(Context context)
    {
        super(context);
    }

    public int GetSteps()
    {
        int steps = 0;
        try
        {
            String sql = "SELECT " + GOALS_TABLE_COLUMN_VALUES
                       + " FROM " + TARGET_GOALS_TABLE
                       + " WHERE " + GOALS_TABLE_ID + " = 'STEPS'";

            SQLiteDatabase database = getWritableDatabase();
            Cursor cursor = database.rawQuery(sql, null);
            if(cursor.moveToFirst())
            {
                do
                {
                    Log.i("TAG", "Steps: " + cursor.getInt(0));
                    steps = cursor.getInt(0);
                }
                while (cursor.moveToNext());
            }
        }
        catch (Exception ex)
        {
            Log.i("TAG", "Exception: " + ex.getMessage());
            ex.printStackTrace();
        }

        return steps;
    }

    public int GetSleep()
    {
        int sleep = 0;
        try
        {
            String sql = "SELECT " + GOALS_TABLE_COLUMN_VALUES
                       + " FROM " + TARGET_GOALS_TABLE
                       + " WHERE " + GOALS_TABLE_ID + " = 'SLEEP'";

            SQLiteDatabase database = getWritableDatabase();
            Cursor cursor = database.rawQuery(sql, null);
            if(cursor.moveToFirst())
            {
                do
                {
                    Log.i("TAG", "Sleep: " + cursor.getInt(0));
                    sleep = cursor.getInt(0);
                }
                while (cursor.moveToNext());
            }
        }
        catch (Exception ex)
        {
            Log.i("TAG", "Exception: " + ex.getMessage());
            ex.printStackTrace();
        }

        return sleep;
    }

    public int GetCalories()
    {
        int cals = 0;
        try
        {
            String sql = "SELECT " + GOALS_TABLE_COLUMN_VALUES
                       + " FROM " + TARGET_GOALS_TABLE
                       + " WHERE " + GOALS_TABLE_ID + " = 'CALS'";

            SQLiteDatabase database = getWritableDatabase();
            Cursor cursor = database.rawQuery(sql, null);
            if(cursor.moveToFirst())
            {
                do
                {
                    Log.i("TAG", "Cals: " + cursor.getInt(0));
                    cals = cursor.getInt(0);
                }
                while (cursor.moveToNext());
            }
        }
        catch (Exception ex)
        {
            Log.i("TAG", "Exception: " + ex.getMessage());
            ex.printStackTrace();
        }

        return cals;
    }

    public boolean UpdateGoals(int steps, int sleep, int calories)
    {
        boolean success;

        ContentValues contentValuesSteps = new ContentValues();
        contentValuesSteps.put(GOALS_TABLE_COLUMN_VALUES, steps);
        String whereSteps = " 'STEPS' = " + GOALS_TABLE_ID;

        ContentValues contentValuesSleep = new ContentValues();
        contentValuesSleep.put(GOALS_TABLE_COLUMN_VALUES, sleep);
        String whereSleep = " 'SLEEP' = " + GOALS_TABLE_ID;

        ContentValues contentValuesCals = new ContentValues();
        contentValuesCals.put(GOALS_TABLE_COLUMN_VALUES, calories);
        String whereCals = " 'CALS' = " + GOALS_TABLE_ID;

        try
        {
            SQLiteDatabase database = getWritableDatabase();
            database.update(TARGET_GOALS_TABLE, contentValuesSteps, whereSteps, null);
            database.update(TARGET_GOALS_TABLE, contentValuesCals, whereCals, null);
            database.update(TARGET_GOALS_TABLE, contentValuesSleep, whereSleep, null);

            success = true;
        }
        catch (Exception ex)
        {
            success = false;
            Log.i("TAG", "Exception: " + ex.getMessage());
            ex.printStackTrace();
        }

        return success;
    }

}
