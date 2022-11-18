package com.cip.TermInator.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.cip.TermInator.model.Course;

import java.util.List;

@Dao
public interface CourseDao {
    @Query("SELECT * FROM course")
    List<Course> getAllCourses();

    @Insert
    void insertCourse(Course... courses);

    @Delete
    void delete(Course course);
}
