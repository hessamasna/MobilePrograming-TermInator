package com.cip.TermInator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.cip.TermInator.adapter.CourseAdapter;
import com.cip.TermInator.adapter.UniversityFacultiesAdapter;
import com.cip.TermInator.db.AppDatabase;
import com.cip.TermInator.model.Course;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Course> courseList;
    private HashMap<String, String> universityFaculties = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loadUniversityFaculties();
//        initialData();
        loadCourses("ALL");

        setCoursesRecyclerView();
        setFacultiesRecyclerView();

    }

    private void setCoursesRecyclerView() {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        RecyclerView recyclerView = findViewById(R.id.Classes_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        CourseAdapter courseAdapter = new CourseAdapter(this, courseList,db);
        recyclerView.setAdapter(courseAdapter);

    }

    private void setFacultiesRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.university_faculties_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<String> Faculties = new ArrayList<String>(universityFaculties.keySet());
        UniversityFacultiesAdapter universityFacultiesAdapter = new UniversityFacultiesAdapter(this, Faculties);
        recyclerView.setAdapter(universityFacultiesAdapter);
    }


    private void loadUniversityFaculties() {
        universityFaculties.put("Math", "3.json");
        universityFaculties.put("Physics", "5.json");
        universityFaculties.put("Ce", "38.json");
    }

    public void loadCourses(String key) {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        if (key.equals("ALL"))
            courseList = db.courseDao().getAllCourses();
        else
            courseList = db.courseDao().selectUniversityFaculties(key);

        System.out.println(db.courseDao().selectHasCourse());
        setCoursesRecyclerView();
    }

    private void initialData() {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        db.courseDao().deleteAll();

        for (String i : universityFaculties.keySet()) {
            db.courseDao().insertCourse(readJson(i, universityFaculties.get(i)));
        }

    }

    private Course[] readJson(String universityFaculty, String path) {
        StringBuilder returnString = new StringBuilder();
        Gson gson = new Gson();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("json/" + path)));

            String mLine;
            while ((mLine = reader.readLine()) != null) {
                returnString.append(mLine);
            }
        } catch (IOException e) {
            Log.d("Status:", "fucked Up");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.d("Status:", "fucked Up");
                }
            }
        }
        Course[] courses = gson.fromJson(String.valueOf(returnString), Course[].class);
        for (Course course : courses) {
            course.setUniversityFaculties(universityFaculty);
        }
        return courses;
    }


    public void loadList(View view) {
        TextView b = (TextView)view;
        String buttonText = b.getText().toString();
        loadCourses(buttonText);
    }

    public void goToWeeklyActivity(View view){
        Intent secondActivityIntent = new Intent(
                getApplicationContext(), Weekly.class
        );
        startActivity(secondActivityIntent);
    }

}