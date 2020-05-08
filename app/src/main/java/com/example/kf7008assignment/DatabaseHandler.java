package com.example.kf7008assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public abstract class DatabaseHandler extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "database.db";


    public static final String TARGET_GOALS_TABLE = "TARGET_GOALS";
    public static final String GOALS_TABLE_COLUMN_VALUES = "VALUES";
    public static final String GOALS_TABLE_COLUMN_GOALS_NAME = "GOALS";

    private static final String CREATE_GOALS_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                    + TARGET_GOALS_TABLE
                                                    + " (_id integer primary key autoincrement, "
                                                    + GOALS_TABLE_COLUMN_GOALS_NAME + " TEXT, "
                                                    + GOALS_TABLE_COLUMN_VALUES + " INTEGER);";

    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try
        {
            db.execSQL(CREATE_GOALS_TABLE);

            ContentValues contentValues = new ContentValues();
            contentValues.put("STEPS", 10);

            long result = db.insert(TARGET_GOALS_TABLE, null, contentValues);
            if(result != 0)
            {
                Log.i("TAG", "E");
            }
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
    //    String sql = "DROP TABLE IF EXISTS " + TARGET_GOALS_TABLE;
     //   db.execSQL(sql);
    }


}
