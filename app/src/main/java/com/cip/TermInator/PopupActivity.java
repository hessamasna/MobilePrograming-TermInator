package com.cip.TermInator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PopupActivity extends AppCompatActivity {

    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        myDialog = new Dialog(this);
    }

    public void showPopup(View v){
        TextView courseName;
        TextView courseTime;
        TextView courseExam;
        Button saveBtn;
        Button cancelBtn;

        myDialog.setContentView(R.layout.activity_popup);

        courseName = (TextView) myDialog.findViewById(R.id.courseName);
        courseTime = (TextView) myDialog.findViewById(R.id.courseTime);
        courseExam = (TextView) myDialog.findViewById(R.id.courseExam);
        cancelBtn = (Button) myDialog.findViewById(R.id.cancelBtn);
        saveBtn = (Button) myDialog.findViewById(R.id.saveBtn);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }
}