package com.muhammadshahmeer.u_care;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    public static String DBNAME="mytasks.db";
    public static int VERSION=1;

    public static String CREATE_TASK_TABLE="CREATE TABLE "+
            MyTasks.MyTask.TABLE_NAME +" ( "+
            MyTasks.MyTask._ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            MyTasks.MyTask._EXE +" TEXT, "+" TEXT NOT NULL "+
            " );";

    public static String DROPE_TASK_TABLE="DROP TABLE IF EXISTS "+
            MyTasks.MyTask.TABLE_NAME;

    public MyDBHelper(@Nullable Context context) {
        super(context, DBNAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TASK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROPE_TASK_TABLE);
        onCreate(sqLiteDatabase);

    }
}
