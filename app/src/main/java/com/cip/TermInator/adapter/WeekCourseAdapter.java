package com.cip.TermInator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cip.TermInator.R;
import com.cip.TermInator.db.AppDatabase;
import com.cip.TermInator.model.Course;
import com.cip.TermInator.model.CourseTime;
import com.cip.TermInator.model.WeekCourses;
import com.google.gson.Gson;

import java.util.List;

public class WeekCourseAdapter extends RecyclerView.Adapter<WeekCourseAdapter.WeekCourseHolder> {

    private Context context;
    private List<Integer> weekDaysArrayList;
//    private List<String> week;
    private AppDatabase db;



    public WeekCourseAdapter(Context context, List courseArrayList,AppDatabase db) {
        this.context = context;
        this.weekDaysArrayList = courseArrayList;
        this.db = db;
    }

    @NonNull
    @Override
    public WeekCourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.week_course_item, parent, false);

        return new WeekCourseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeekCourseHolder holder, int position) {
        int weekDay = weekDaysArrayList.get(position);
        holder.setData(weekDay, position);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(context, "clicked" + courseArrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
//                Course clickedCourse = courseArrayList.get(position);
//                clickedCourse.setHasCourse(true);
//                db.courseDao().update(clickedCourse);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return weekDaysArrayList.size();
    }

    /////////////

    class WeekCourseHolder extends RecyclerView.ViewHolder {

        private TextView week_course_name,week_course_start_time,week_course_end_time;


        public WeekCourseHolder(@NonNull View itemView) {
            super(itemView);
            week_course_name = itemView.findViewById(R.id.week_course_name);
            week_course_start_time = itemView.findViewById(R.id.week_course_start_time);
            week_course_end_time = itemView.findViewById(R.id.week_course_end_time);
        }

        public void setData(int id, int position) {
            Gson gson= new Gson();

            Course course = db.courseDao().getCourse(id);
            CourseTime[] courseTimes = gson.fromJson(String.valueOf(course.getClass_times()), CourseTime[].class);
            week_course_name.setText(course.getName());
            week_course_start_time.setText(courseTimes[0].getStart());
            week_course_end_time.setText(courseTimes[0].getEnd());
//            week_day_courses_recycler.setText("start");

        }
    }
}
