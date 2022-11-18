package com.cip.TermInator.model;

import java.util.ArrayList;

public class Course {
    private int id;
    private String info;
    private String course_id;
    private int course_number;
    private String name;
    private int units;
    private int capacity;
    private String instructor;
    private ArrayList<CourseTime> courseTime;
    private String exam_time;

    public Course(int id, String info, String course_id, int course_number, String name, int units, int capacity, String instructor, String exam_time) {
        this.id = id;
        this.info = info;
        this.course_id = course_id;
        this.course_number = course_number;
        this.name = name;
        this.units = units;
        this.capacity = capacity;
        this.instructor = instructor;
        this.courseTime = new ArrayList<>();
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

    public ArrayList<CourseTime> getClassTime() {
        return courseTime;
    }

    public void setClassTime(ArrayList<CourseTime> courseTime) {
        this.courseTime = courseTime;
    }

    public String getExam_time() {
        return exam_time;
    }

    public void setExam_time(String exam_time) {
        this.exam_time = exam_time;
    }

    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", course_id='" + course_id + '\'' +
                ", course_number=" + course_number +
                ", name='" + name + '\'' +
                ", units=" + units +
                ", capacity=" + capacity +
                ", instructor='" + instructor + '\'' +
                ", classTime=" + courseTime +
                ", exam_time='" + exam_time + '\'' +
                '}';
    }
}