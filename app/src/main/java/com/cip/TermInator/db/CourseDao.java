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

    @Query("SELECT * FROM course WHERE university_faculties LIKE :name")
    List<Course> selectUniversityFaculties(String name);

    @Insert
    void insertCourse(Course... courses);

    @Delete
    void delete(Course course);

    @Query("DELETE FROM course")
    void deleteAll();

}
