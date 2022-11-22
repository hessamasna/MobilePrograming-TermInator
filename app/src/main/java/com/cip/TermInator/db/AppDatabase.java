package com.cip.TermInator.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.cip.TermInator.model.Course;
import com.cip.TermInator.model.WeekCourses;

@Database(entities = {Course.class, WeekCourses.class}, version = 5)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CourseDao courseDao();
    public abstract WeekCoursesDao weekCoursesDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDbInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "DB_NAME")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return INSTANCE;
    }
}
