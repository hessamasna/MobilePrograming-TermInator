package com.cip.TermInator.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class WeekCourses {
    @PrimaryKey(autoGenerate = false)
    public int id;
    @ColumnInfo(name = "day_0")
    private String day0;
    @ColumnInfo(name = "day_1")
    private String day1;
    @ColumnInfo(name = "day_2")
    private String day2;
    @ColumnInfo(name = "day_3")
    private String day3;
    @ColumnInfo(name = "day_4")
    private String day4;
    @ColumnInfo(name = "day_5")
    private String day5;
    @ColumnInfo(name = "day_6")
    private String day6;

    public WeekCourses() {
        this.day0 = "";
        this.day1 = "";
        this.day2 = "";
        this.day3 = "";
        this.day4 = "";
        this.day5 = "";
        this.day6 = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay0() {
        return day0;
    }

    public void setDay0(String day0) {
        this.day0 = day0;
    }

    public String getDay1() {
        return day1;
    }

    public void setDay1(String day1) {
        this.day1 = day1;
    }

    public String getDay2() {
        return day2;
    }

    public void setDay2(String day2) {
        this.day2 = day2;
    }

    public String getDay3() {
        return day3;
    }

    public void setDay3(String day3) {
        this.day3 = day3;
    }

    public String getDay4() {
        return day4;
    }

    public void setDay4(String day4) {
        this.day4 = day4;
    }

    public String getDay5() {
        return day5;
    }

    public void setDay5(String day5) {
        this.day5 = day5;
    }

    public String getDay6() {
        return day6;
    }

    public void setDay6(String day6) {
        this.day6 = day6;
    }

    public void concatDay(String day, int courseId) {
        switch (day) {
            case "0":
                this.day0 += courseId + "*";
                break;

            case "1":
                this.day1 += courseId + "*";
                break;

            case "2":
                this.day2 += courseId + "*";
                break;

            case "3":
                this.day3 += courseId + "*";
                break;

            case "4":
                this.day4 += courseId + "*";
                break;

            case "5":
                this.day5 += courseId + "*";
                break;

            case "6":
                this.day6 += courseId + "*";
                break;
        }
    }

    @Override
    public String toString() {
        return "WeekCourses{" +
                "id=" + id +
                ", day0='" + day0 + '\'' +
                ", day1='" + day1 + '\'' +
                ", day2='" + day2 + '\'' +
                ", day3='" + day3 + '\'' +
                ", day4='" + day4 + '\'' +
                ", day5='" + day5 + '\'' +
                ", day6='" + day6 + '\'' +
                '}';
    }
}
