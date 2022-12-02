package com.cip.TermInator.adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cip.TermInator.MainActivity;
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
    public void onBindViewHolder(@NonNull WeekCourseHolder holder, @SuppressLint("RecyclerView") int position) {
        int weekDay = weekDaysArrayList.get(position);
        holder.setData(weekDay, position);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Course course = db.courseDao().getCourse(weekDay);
                showRemovePopup(v, course);
            }
        });
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

    public void goToMainActivity(View view, Context context){
        Intent secondActivityIntent = new Intent(
                context, MainActivity.class
        );
        //startActivity(secondActivityIntent);
        context.startActivity(secondActivityIntent);
    }

    public void showRemovePopup(View v, Course course) {
        TextView courseName;
        TextView courseTime;
        TextView courseExam;
        Button saveBtn;
        Button cancelBtn;

        Dialog myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_remove_popup);
        myDialog.getWindow().setBackgroundDrawableResource(R.drawable.shap);

        courseName = (TextView) myDialog.findViewById(R.id.courseTitle);
        courseTime = (TextView) myDialog.findViewById(R.id.courseDate);
        courseExam = (TextView) myDialog.findViewById(R.id.courseFinal);
        cancelBtn = (Button) myDialog.findViewById(R.id.cancelBtn2);
        saveBtn = (Button) myDialog.findViewById(R.id.removeBtn);
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

                Toast.makeText(context, "حذف شد»" + course.getName(), Toast.LENGTH_SHORT).show();
                course.setHasCourse(false);
                db.courseDao().update(course);
                myDialog.dismiss();
                goToMainActivity(v,context);
            }
        });


        myDialog.show();
    }
}
