package com.cip.TermInator.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import com.cip.TermInator.R;
import com.cip.TermInator.db.AppDatabase;
import com.cip.TermInator.model.Course;
import com.cip.TermInator.model.CourseTime;
import com.google.gson.Gson;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseHolder> {

    private Context context;
    private List<Course> courseArrayList;
    private AppDatabase db;


    public CourseAdapter(Context context, List<Course> courseArrayList, AppDatabase db) {
        this.context = context;
        this.courseArrayList = courseArrayList;
        this.db = db;
    }

    @NonNull
    @Override
    public CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.course_layout_item, parent, false);

        return new CourseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseHolder holder, @SuppressLint("RecyclerView") int position) {
        Course course = courseArrayList.get(position);
        holder.setData(course);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "clicked" + courseArrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
                Course clickedCourse = courseArrayList.get(position);
                clickedCourse.setHasCourse(true);
                db.courseDao().update(clickedCourse);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseArrayList.size();
    }

    /////////////

    class CourseHolder extends RecyclerView.ViewHolder {

        private TextView course_name_view, course_time_1, course_time_2, course_instructor, course_units;


        public CourseHolder(@NonNull View itemView) {
            super(itemView);
            course_name_view = itemView.findViewById(R.id.course_name_view);
            course_time_1 = itemView.findViewById(R.id.course_time_1);
            course_time_2 = itemView.findViewById(R.id.course_time_2);
            course_instructor = itemView.findViewById(R.id.course_instructor);
            course_units = itemView.findViewById(R.id.course_units);
        }

        public void setData(Course course) {
            Gson gson = new Gson();
            CourseTime[] courseTimes = gson.fromJson(String.valueOf(course.getClass_times()), CourseTime[].class);

            course_name_view.setText(course.getName());
            course_time_1.setText(courseTimes[0].getStart());
            course_time_2.setText(courseTimes[0].getEnd());
            course_instructor.setText(course.getInstructor());
            course_units.setText(Integer.toString(course.getUnits()));
        }
    }
}
