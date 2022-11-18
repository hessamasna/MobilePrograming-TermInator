package com.cip.TermInator.model;

public class CourseTime {
    private int id;
    private String start;
    private String end;
    private String day;

    public CourseTime(int id, String start, String end, String day) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "CourseTime{" +
                "id=" + id +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
