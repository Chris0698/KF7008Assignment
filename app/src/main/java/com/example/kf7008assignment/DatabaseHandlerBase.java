package com.example.kf7008assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public abstract class DatabaseHandlerBase extends SQLiteOpenHelper
{
    //static final used for constants, increases execution speed according to the
    //docs: https://developer.android.com/training/articles/perf-tips
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "database.db";

    protected static final String TARGET_GOALS_TABLE = "TARGET_GOALS";
    protected static final String GOALS_TABLE_COLUMN_VALUES = "TARGET";
    protected static final String GOALS_TABLE_ID = "ID";

    public DatabaseHandlerBase(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        //needed this apparently because onCreate was never called
        getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Log.i("TAG", "Database creation");
        try
        {
            //create target goals table
            String sql = "CREATE TABLE " + TARGET_GOALS_TABLE + " ( " + GOALS_TABLE_ID + " TEXT PRIMARY KEY, "
                       + GOALS_TABLE_COLUMN_VALUES + " INTEGER);";
            db.execSQL(sql);

            ContentValues contentValuesSteps = new ContentValues();
            contentValuesSteps.put(GOALS_TABLE_ID, "STEPS");
            contentValuesSteps.put(GOALS_TABLE_COLUMN_VALUES, 0);

            ContentValues contentValuesSleep = new ContentValues();
            contentValuesSleep.put(GOALS_TABLE_ID, "SLEEP");
            contentValuesSleep.put(GOALS_TABLE_COLUMN_VALUES, 0);

            ContentValues contentValuesCals = new ContentValues();
            contentValuesCals.put(GOALS_TABLE_ID, "CALS");
            contentValuesCals.put(GOALS_TABLE_COLUMN_VALUES, 0);

            db.insert(TARGET_GOALS_TABLE, null, contentValuesSteps);
            db.insert(TARGET_GOALS_TABLE, null, contentValuesSleep);
            db.insert(TARGET_GOALS_TABLE, null, contentValuesCals);
        }
        catch (Exception ex)
        {
            Log.i("TAG", "Exception: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
         String sql = "DROP TABLE IF EXISTS " + TARGET_GOALS_TABLE;
         db.execSQL(sql);
    }
}
