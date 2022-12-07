package com.muhammadshahmeer.u_care;

import android.provider.BaseColumns;

public class MyTasks {
    private MyTasks(){}

    public static class MyTask implements BaseColumns {
        public static String TABLE_NAME="Tasks";
        public static String _EXE="Task";


    }
}
