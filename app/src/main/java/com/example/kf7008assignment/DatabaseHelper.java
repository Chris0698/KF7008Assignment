package com.example.kf7008assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final int VERSION = 1;
    private static final String NAME = "database.db";
    private static final String TABLE_NAME_GOALS = "goalsTable";

    private static final String COL_NAME = "GOALS";

    public DatabaseHelper(Context context)
    {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //String createTable = "CREATE TABLE " + TABLE_NAME_GOALS + " (ID_GOALS INTEGER PRIMARY KEY AUTOINCREMENT, )";
      //  db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_GOALS);
        onCreate(db);
    }

    public boolean UpdateGoals(int steps, int sleep, int calories)
    {
//        SQLiteDatabase database = getWritableDatabase();
//        ContentValues contentValuesSteps = new ContentValues();
//        ContentValues contentValuesSleep = new ContentValues();
//        ContentValues contentValuesCalories = new ContentValues();
//
//        contentValuesSteps.put("STEPS", steps);
//        contentValuesSleep.put("sleep", sleep);
//        contentValuesCalories.put("calories", calories);
//
//        long result = database.insert(TABLE_NAME_GOALS, null, contentValuesSteps);
//        if(result == -1)
//        {
//            return false;
//        }
//        else
//        {
//            return true;
//        }

        return true;
    }

    public int GetSteps()
    {
        SQLiteDatabase database = getWritableDatabase();
        return  0;
    }
}
