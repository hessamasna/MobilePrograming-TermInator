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

    @Query("SELECT :colId FROM weekcourses WHERE id = :id")
    String getDayCourses(String colId, int id);

    @Query("SELECT day_0 FROM weekcourses WHERE id = :id")
    String day_0(int id);

    @Query("SELECT day_1 FROM weekcourses WHERE id = :id")
    String day_1(int id);

    @Query("SELECT day_2 FROM weekcourses WHERE id = :id")
    String day_2(int id);

    @Query("SELECT day_3 FROM weekcourses WHERE id = :id")
    String day_3(int id);

    @Query("SELECT day_4 FROM weekcourses WHERE id = :id")
    String day_4(int id);

    @Query("SELECT day_5 FROM weekcourses WHERE id = :id")
    String day_5(int id);

    @Query("SELECT day_6 FROM weekcourses WHERE id = :id")
    String day_6(int id);


    @Insert
    void insertWeekCourse(WeekCourses... weekCourses);

    @Delete
    void deleteWeekCourse(WeekCourses weekCourses);

    @Update
    void updateWeekCourse(WeekCourses weekCourses);

    @Query("DELETE FROM weekcourses")
    void deleteAllWeekCourses();

}
