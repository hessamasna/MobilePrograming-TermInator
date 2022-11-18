package com.cip.TermInator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cip.TermInator.R;
import com.cip.TermInator.model.Course;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseHolder> {

    private Context context;
    private ArrayList<Course> courseArrayList;

    public CourseAdapter(Context context, ArrayList<Course> courseArrayList) {
        this.context = context;
        this.courseArrayList = courseArrayList;
    }

    @NonNull
    @Override
    public CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.course_layout_item,parent,false);

        return new CourseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseHolder holder, int position) {
        Course course = courseArrayList.get(position);
        holder.setData(course);
    }

    @Override
    public int getItemCount() {
        return courseArrayList.size();
    }

    /////////////

    class CourseHolder extends RecyclerView.ViewHolder {

        private TextView course_name, course_time_1, course_time_2, course_instructor, course_units;


        public CourseHolder(@NonNull View itemView) {
            super(itemView);
            course_name = itemView.findViewById(R.id.course_name);
            course_time_1 = itemView.findViewById(R.id.course_time_1);
            course_time_2 = itemView.findViewById(R.id.course_time_2);
            course_instructor = itemView.findViewById(R.id.course_instructor);
            course_units = itemView.findViewById(R.id.course_units);
        }

        public void setData(Course course){
            course_name.setText(course.getName());
            course_time_1.setText(course.getClassTime().get(0).getStart());
            course_time_2.setText(course.getClassTime().get(1).getStart());
            course_instructor.setText(course.getInstructor());
            course_units.setText(Integer.toString(course.getUnits()));
        }
    }
}
