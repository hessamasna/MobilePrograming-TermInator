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

import com.cip.TermInator.R;
import com.cip.TermInator.db.AppDatabase;
import com.cip.TermInator.model.Course;
import com.cip.TermInator.model.WeekCourses;

import java.util.List;

public class WeekDaysAdapter extends RecyclerView.Adapter<WeekDaysAdapter.WeekDaysHolder> {

    private Context context;
    private List<WeekCourses> weekDaysArrayList;
    private List<String> week;


    public WeekDaysAdapter(Context context, List<WeekCourses> courseArrayList, List<String> week) {
        this.context = context;
        this.weekDaysArrayList = courseArrayList;
        this.week = week;
    }

    @NonNull
    @Override
    public WeekDaysHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.week_days_item, parent, false);

        return new WeekDaysHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeekDaysHolder holder, int position) {
        String weekDay = week.get(position);
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
        return week.size();
    }

    /////////////

    class WeekDaysHolder extends RecyclerView.ViewHolder {

        private TextView week_day_name;
        private RecyclerView week_day_courses_recycler;


        public WeekDaysHolder(@NonNull View itemView) {
            super(itemView);
            week_day_name = itemView.findViewById(R.id.week_day_name);
            week_day_courses_recycler = itemView.findViewById(R.id.week_day_courses_recycler);
        }

        public void setData(String weekDay, int position) {
            week_day_name.setText(weekDay);
//            week_day_courses_recycler.setText("start");

        }
    }
}
