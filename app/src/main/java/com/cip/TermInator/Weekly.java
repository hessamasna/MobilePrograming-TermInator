package com.cip.TermInator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cip.TermInator.adapter.CourseAdapter;
import com.cip.TermInator.adapter.WeekDaysAdapter;
import com.cip.TermInator.db.AppDatabase;
import com.cip.TermInator.model.Course;
import com.cip.TermInator.model.CourseTime;
import com.cip.TermInator.model.WeekCourses;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Weekly extends AppCompatActivity {

    private List<WeekCourses> weekCoursesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly);


        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<Course> courses = db.courseDao().selectHasCourse();

        Gson gson = new Gson();
        WeekCourses weekCourse = new WeekCourses();

        for (Course course : courses) {
            CourseTime[] courseTimes = gson.fromJson(String.valueOf(course.getClass_times()), CourseTime[].class);
            for (CourseTime courseTime : courseTimes) {
                weekCourse.concatDay(courseTime.getDay(), course.getUid());
            }
        }
        db.weekCoursesDao().insertWeekCourse(weekCourse);

        weekCoursesList = db.weekCoursesDao().getAllWeekCourses();

        setCoursesRecyclerView();
    }

    private void setCoursesRecyclerView() {
        List<String> week = Arrays.asList("شنیه", "یک شنیه", "دو شنیه", "سه شنیه", "چهار شنیه", "پنج شنیه", "جمعه");

//        List<String> week = new ArrayList<>();
//        week.add("شنیه");
//        week.add("یک شنیه");
//        week.add("دو شنیه");
//        week.add("سه شنیه");
//        week.add("چهار شنیه");
//        week.add("پنج شنیه");
//        week.add("جمعه");

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        RecyclerView recyclerView = findViewById(R.id.week_days_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        WeekDaysAdapter courseAdapter = new WeekDaysAdapter(this, weekCoursesList,week);
        recyclerView.setAdapter(courseAdapter);

    }
}