package com.cip.TermInator.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.cip.TermInator.db.AppDatabase;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    public void concatDay(String day, int courseId, AppDatabase db) {
        switch (day) {
            case "0":
                this.day0 += courseId + "*";
                this.day0 = sortCourses(this.day0, db);
                break;

            case "1":
                this.day1 += courseId + "*";
                this.day1 = sortCourses(this.day1, db);
                break;

            case "2":
                this.day2 += courseId + "*";
                this.day2 = sortCourses(this.day2, db);
                break;

            case "3":
                this.day3 += courseId + "*";
                this.day3 = sortCourses(this.day3, db);
                break;

            case "4":
                this.day4 += courseId + "*";
                this.day4 = sortCourses(this.day4, db);
                break;

            case "5":
                this.day5 += courseId + "*";
                this.day5 = sortCourses(this.day5, db);
                break;

            case "6":
                this.day6 += courseId + "*";
                this.day6 = sortCourses(this.day6, db);
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

    private String sortCourses(String ids, AppDatabase db) {
        String[] splitIds = ids.split("\\*");
        HashMap<String, Double> courseIdWithStartTime = new HashMap<>();
        Gson gson = new Gson();

        for (String splitId : splitIds) {
            Course course = db.courseDao().getCourse(Integer.parseInt(splitId));
            CourseTime[] courseTimes = gson.fromJson(String.valueOf(course.getClass_times()), CourseTime[].class);
            courseIdWithStartTime.put(splitId, Double.parseDouble(courseTimes[0].getStart()));
        }

        courseIdWithStartTime = sortByValue(courseIdWithStartTime);
        String res = "";
        for (String i : courseIdWithStartTime.keySet()) {
            res += i + "*";
        }

        return res;
    }

    private HashMap<String, Double>
    sortByValue(HashMap<String, Double> hm) {
        List<Map.Entry<String, Double>> list
                = new LinkedList<Map.Entry<String, Double>>(
                hm.entrySet());

        Collections.sort(
                list,
                new Comparator<Map.Entry<String, Double>>() {
                    public int compare(
                            Map.Entry<String, Double> object1,
                            Map.Entry<String, Double> object2) {
                        return (object1.getValue())
                                .compareTo(object2.getValue());
                    }
                });

        HashMap<String, Double> result
                = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> me : list) {
            result.put(me.getKey(), me.getValue());
        }

        return result;
    }
}
