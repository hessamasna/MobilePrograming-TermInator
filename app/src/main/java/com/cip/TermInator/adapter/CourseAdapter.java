package com.cip.TermInator.adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

//                Toast.makeText(context, "clicked" + courseArrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
//                Course clickedCourse = courseArrayList.get(position);
//                clickedCourse.setHasCourse(true);
//                db.courseDao().update(clickedCourse);
                showPopup(v, courseArrayList.get(position));

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

    public void showPopup(View v, Course course) {
        TextView courseName;
        TextView courseTime;
        TextView courseExam;
        Button saveBtn;
        Button cancelBtn;

        Dialog myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_add_popup);

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
                    if (!checkCourseDate(course)) {
                        Toast.makeText(context, "تداخل زمانی وجود دارد", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "اضافه شد»" + course.getName(), Toast.LENGTH_SHORT).show();

                        course.setHasCourse(true);
                        db.courseDao().update(course);
                        myDialog.dismiss();
                    }

                }

            }
        });


        myDialog.show();
    }

    private boolean checkCourseDate(Course crs) {
        Gson gson = new Gson();
        List<Course> courses = db.courseDao().selectHasCourse();

        if (courses.size() == 0)
            return true;

        CourseTime[] currentCourseTimes = gson.fromJson(String.valueOf(crs.getClass_times()), CourseTime[].class);

        for (CourseTime currentCourseTime : currentCourseTimes) {
            for (Course course : courses) {
                CourseTime[] courseTimes = gson.fromJson(String.valueOf(course.getClass_times()), CourseTime[].class);
                for (CourseTime courseTime : courseTimes) {
                    if (courseTime.getDay().equals(currentCourseTime.getDay())) {
                        if (Double.parseDouble(courseTime.getStart()) < Double.parseDouble(currentCourseTime.getStart()) && Double.parseDouble(courseTime.getEnd()) > Double.parseDouble(currentCourseTime.getStart())) {
                            return false;
                        }
                        if (Double.parseDouble(courseTime.getStart()) < Double.parseDouble(currentCourseTime.getEnd()) && Double.parseDouble(courseTime.getEnd()) > Double.parseDouble(currentCourseTime.getEnd())) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
