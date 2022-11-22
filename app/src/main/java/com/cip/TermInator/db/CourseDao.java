package com.cip.TermInator.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cip.TermInator.model.Course;

import java.util.List;

@Dao
public interface CourseDao {
    @Query("SELECT * FROM course")
    List<Course> getAllCourses();

    @Query("SELECT * FROM course WHERE uid = :id")
    List<Course> getCourse(int id);

    @Query("SELECT * FROM course WHERE university_faculties LIKE :name")
    List<Course> selectUniversityFaculties(String name);

    @Query("SELECT * FROM course WHERE has_course = 1 ")
    List<Course> selectHasCourse();

    @Insert
    void insertCourse(Course... courses);

    @Delete
    void delete(Course course);

    @Update
    void update(Course course);

    @Query("DELETE FROM course")
    void deleteAll();

}
