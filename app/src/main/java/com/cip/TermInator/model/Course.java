package com.cip.TermInator.model;

import androidx.room.Entity;
import androidx.room.*;

import java.util.ArrayList;

@Entity
public class Course {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "university_faculties")
    private String universityFaculties;
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "info")
    private String info;
    @ColumnInfo(name = "course_id")
    private String course_id;
    @ColumnInfo(name = "course_number")
    private int course_number;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "units")
    private int units;
    @ColumnInfo(name = "capacity")
    private int capacity;
    @ColumnInfo(name = "instructor")
    private String instructor;
    @ColumnInfo(name = "courseTime")
    private String courseTime;
    @ColumnInfo(name = "exam_time")
    private String exam_time;

    public Course(int id, String info, String course_id, int course_number, String name, int units, int capacity, String instructor, String courseTime, String exam_time) {
        this.id = id;
        this.universityFaculties = "";
        this.info = info;
        this.course_id = course_id;
        this.course_number = course_number;
        this.name = name;
        this.units = units;
        this.capacity = capacity;
        this.instructor = instructor;
        this.courseTime = courseTime;
        this.exam_time = exam_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public int getCourse_number() {
        return course_number;
    }

    public void setCourse_number(int course_number) {
        this.course_number = course_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getUniversityFaculties() {
        return universityFaculties;
    }

    public void setUniversityFaculties(String universityFaculties) {
        this.universityFaculties = universityFaculties;
    }

    public String getExam_time() {
        return exam_time;
    }

    public void setExam_time(String exam_time) {
        this.exam_time = exam_time;
    }

}
