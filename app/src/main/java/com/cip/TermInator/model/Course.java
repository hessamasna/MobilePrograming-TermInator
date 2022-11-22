package com.cip.TermInator.model;

import androidx.room.Entity;
import androidx.room.*;

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
    @ColumnInfo(name = "class_times")
    private String class_times;
    @ColumnInfo(name = "exam_time")
    private String exam_time;
    @ColumnInfo(name = "has_course")
    private boolean hasCourse;


    public Course(int id, String info, String course_id, int course_number, String name, int units, int capacity, String instructor, String class_times, String exam_time) {
        this.id = id;
        this.universityFaculties = "";
        this.info = info;
        this.course_id = course_id;
        this.course_number = course_number;
        this.name = name;
        this.units = units;
        this.capacity = capacity;
        this.instructor = instructor;
        this.class_times = class_times;
        this.exam_time = exam_time;
        this.hasCourse = false;
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

    public String getClass_times() {
        return class_times;
    }

    public void setClass_times(String class_times) {
        this.class_times = class_times;
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

    public boolean isHasCourse() {
        return hasCourse;
    }

    public void setHasCourse(boolean hasCourse) {
        this.hasCourse = hasCourse;
    }

    @Override
    public String toString() {
        return "Course{" +
                "uid=" + uid +
                ", universityFaculties='" + universityFaculties + '\'' +
                ", id=" + id +
                ", info='" + info + '\'' +
                ", course_id='" + course_id + '\'' +
                ", course_number=" + course_number +
                ", name='" + name + '\'' +
                ", units=" + units +
                ", capacity=" + capacity +
                ", instructor='" + instructor + '\'' +
                ", class_times='" + class_times + '\'' +
                ", exam_time='" + exam_time + '\'' +
                ", hasCourse=" + hasCourse +
                '}';
    }
}
