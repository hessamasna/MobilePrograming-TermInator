package com.cip.TermInator.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Dialog;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cip.TermInator.R;
import com.cip.TermInator.db.AppDatabase;
import com.cip.TermInator.model.Course;
import com.cip.TermInator.model.WeekCourses;

import java.util.ArrayList;
import java.util.List;

public class WeekDaysAdapter extends RecyclerView.Adapter<WeekDaysAdapter.WeekDaysHolder> {
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private RecyclerView week_day_courses_recycler;

    private Context context;
    private List<WeekCourses> weekDaysArrayList;
    private List<String> week;
    private AppDatabase db;


    public WeekDaysAdapter(Context context, List<WeekCourses> courseArrayList, List<String> week, AppDatabase db) {
        this.context = context;
        this.weekDaysArrayList = courseArrayList;
        this.week = week;
        this.db = db;
    }

    @NonNull
    @Override
    public WeekDaysHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.week_days_item, parent, false);

        return new WeekDaysHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeekDaysHolder holder, @SuppressLint("RecyclerView") int position) {
        String weekDay = week.get(position);
        holder.setData(weekDay, position);

        WeekCourses weekCourses = new WeekCourses();
        System.out.println(db.weekCoursesDao().getAllWeekCourses());
        List<Integer> courseIds = getDataFromRoomDB(position);
        if (courseIds.get(0) != 0) {
            week_day_courses_recycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            WeekCourseAdapter weekCourseAdapter = new WeekCourseAdapter(context, courseIds, db);
            week_day_courses_recycler.setAdapter(weekCourseAdapter);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(context, "clicked" + courseArrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
//                Course clickedCourse = courseArrayList.get(position);
//                clickedCourse.setHasCourse(true);
//                db.courseDao().update(clickedCourse);
                //showPopup(v, courseArrayList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return week.size();
    }

    /////////////

    class WeekDaysHolder extends RecyclerView.ViewHolder {

        private TextView week_day_name;


        public WeekDaysHolder(@NonNull View itemView) {
            super(itemView);
            week_day_name = itemView.findViewById(R.id.week_day_name);
            week_day_courses_recycler = itemView.findViewById(R.id.week_day_courses_recycler);
        }

        public void setData(String weekDay, int position) {
            week_day_name.setText(weekDay);

        }
    }

    public List<Integer> getDataFromRoomDB(int day) {
        String res = null;
        ArrayList<Integer> uids = new ArrayList<>();


        switch (day) {
            case 0:
                res = db.weekCoursesDao().day_0(0);
                break;
            case 1:
                res = db.weekCoursesDao().day_1(0);
                break;
            case 2:
                res = db.weekCoursesDao().day_2(0);
                break;
            case 3:
                res = db.weekCoursesDao().day_3(0);
                break;
            case 4:
                res = db.weekCoursesDao().day_4(0);
                break;
            case 5:
                res = db.weekCoursesDao().day_5(0);
                break;
            case 6:
                res = db.weekCoursesDao().day_6(0);
                break;
        }

        if (res == null || res.equals("")) {
            uids.add(0);
            return uids;
        }

        String[] result = res.split("\\*");

        for (String s : result) {
            uids.add(Integer.parseInt(s));
        }

        return uids;
    }

    public void showPopup(View v, Course course) {
        TextView courseName;
        TextView courseTime;
        TextView courseExam;
        Button saveBtn;
        Button cancelBtn;

        Dialog myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_remove_popup);

        courseName = (TextView) myDialog.findViewById(R.id.courseName);
        courseTime = (TextView) myDialog.findViewById(R.id.courseTime);
        courseExam = (TextView) myDialog.findViewById(R.id.courseExam);
        cancelBtn = (Button) myDialog.findViewById(R.id.cancelBtn);
        saveBtn = (Button) myDialog.findViewById(R.id.saveBtn);
        courseName.setText(course.getName());
        courseExam.setText(course.getExam_time());
        courseTime.setText(course.getInfo());

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (db.courseDao().checkCourse(course.uid)) {
                    Toast.makeText(context, "قبلا اضافه شده است", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(context, "حذف شد»" + course.getName(), Toast.LENGTH_SHORT).show();

                    course.setHasCourse(false);
                    db.courseDao().update(course);
                    myDialog.dismiss();
                }

            }
        });


        myDialog.show();
    }

}
