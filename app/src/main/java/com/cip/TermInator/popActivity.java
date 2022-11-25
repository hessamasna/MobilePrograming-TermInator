package com.cip.TermInator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cip.TermInator.model.Course;

public class popActivity extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private TextView courseName;
    private Button buttonSave, buttonCancel;

    public void createNewD(Course course){
        System.out.println(course.toString());
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.activity_pop,null);

        courseName = (TextView) contactPopupView.findViewById(R.id.courseName);
        buttonSave = (Button) contactPopupView.findViewById(R.id.buttonSave);
        buttonCancel = (Button) contactPopupView.findViewById(R.id.buttonCancel);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.show();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
    }
}


