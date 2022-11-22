package com.cip.TermInator.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cip.TermInator.model.WeekCourses;

import java.util.List;

@Dao
public interface WeekCoursesDao {
    @Query("SELECT * FROM weekcourses")
    List<WeekCourses> getAllWeekCourses();

    @Query("SELECT * FROM weekcourses WHERE id = :id")
    List<WeekCourses> getWeekCourse(int id);

    @Insert
    void insertWeekCourse(WeekCourses... weekCourses);

    @Delete
    void deleteWeekCourse(WeekCourses weekCourses);

    @Update
    void updateWeekCourse(WeekCourses weekCourses);

    @Query("DELETE FROM weekcourses")
    void deleteAllWeekCourses();

}
