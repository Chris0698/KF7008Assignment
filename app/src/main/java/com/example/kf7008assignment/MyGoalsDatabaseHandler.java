package com.example.kf7008assignment;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MyGoalsDatabaseHandler extends DatabaseHandler
{
    public MyGoalsDatabaseHandler(Context context)
    {
        super(context);
    }

    public int GetSteps()
    {
        int steps = 500;
        try
        {
            String sql = "Select " + GOALS_TABLE_COLUMN_VALUES + " from " + GOALS_TABLE_COLUMN_GOALS_NAME + " where " + GOALS_TABLE_COLUMN_GOALS_NAME + " = GOALS;";
            SQLiteDatabase database = getWritableDatabase();
            Cursor cursor = database.rawQuery(sql, null);
            if(cursor.moveToFirst())
            {
                do
                {
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
        return 8;
    }

    public int GetCalories()
    {
        return 300;
    }
}
