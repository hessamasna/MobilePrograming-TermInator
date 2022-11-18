package com.cip.TermInator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.cip.TermInator.adapter.CourseAdapter;
import com.cip.TermInator.model.Course;
import com.cip.TermInator.model.CourseTime;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Course> courseArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.Classes_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseArrayList = new ArrayList<>();

        CourseAdapter courseAdapter = new CourseAdapter(this, courseArrayList);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        initialData();

    }

    private void initialData() {
        ArrayList<CourseTime> courseTimes = new ArrayList<>();
        courseTimes.add(new CourseTime(1, "start", "End", "day"));
        courseTimes.add(new CourseTime(2, "start", "End", "day"));
        Course course = new Course(1, "info", "course_id", 2, "name", 3, 4, "instructor", "exam");
        course.setClassTime(courseTimes);


        courseArrayList.add(course);
    }


}