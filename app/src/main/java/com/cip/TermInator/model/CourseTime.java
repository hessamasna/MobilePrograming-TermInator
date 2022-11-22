package com.cip.TermInator.model;

public class CourseTime {
    private String start;
    private String end;
    private String day;

    public CourseTime( String start, String end, String day) {
        this.start = start;
        this.end = end;
        this.day = day;
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
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
