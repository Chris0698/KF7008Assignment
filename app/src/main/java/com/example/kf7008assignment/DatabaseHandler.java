package com.example.kf7008assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "database.db";
    private static final String TARGET_GOALS_TABLE = "TARGET_GOALS";

    public static final String COLUMN_ID = "_ID_GOALS";
    public static final String COLUMN_VALUES = "VALUES";

    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTargetGoalsTable = "CREATE TABLE " + TARGET_GOALS_TABLE + " ("
                + COLUMN_ID + " TEXT PRIMARY KEY, " + COLUMN_VALUES + " INTEGER " +
                ")";
        db.execSQL(createTargetGoalsTable);

        //add 0 to the data
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, "steps");
        contentValues.put(COLUMN_VALUES, 10);
        db.insert(TARGET_GOALS_TABLE, null, contentValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String sql = "DROP TABLE IF EXISTS " + TARGET_GOALS_TABLE;
        db.execSQL(sql);
    }

    public int GetGoals()
    {
        SQLiteDatabase database = getWritableDatabase();
        int steps = 0;
        Cursor data = database.query(TARGET_GOALS_TABLE, null, null, null, null, null, null);
        if(data.moveToFirst())
        {
            do
            {
                steps = data.getInt(1);
            }
            while (data.moveToNext());
        }

        return steps;
    }

    public boolean UpdateGoals(int steps, int calories, int sleep)
    {
        return true;
    }
}
