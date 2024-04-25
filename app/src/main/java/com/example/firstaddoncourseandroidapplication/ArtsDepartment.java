package com.example.firstaddoncourseandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ArtsDepartment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts_department);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent artsIntent = getIntent();

        String subDeptName = artsIntent.getStringExtra("subDeptName");

        TextView subDeptHeading = findViewById(R.id.subDeptHeading);

        subDeptHeading.setText(subDeptName);

        TextView aboutPara = findViewById(R.id.aboutPara);
        TextView facultyPara = findViewById(R.id.facultyPara);

        if(subDeptName.equals("COMMUNICATIVE ENGLISH AND MEDIA STUDIES")){
            aboutPara.setText(getString(R.string.arts1));
            facultyPara.setText(getString(R.string.arts1faculties));
        } else if (subDeptName.equals("ENGLISH")) {
            aboutPara.setText(getString(R.string.arts2));
            facultyPara.setText(getString(R.string.arts2faculties));
        }else if (subDeptName.equals("ECONOMICS")) {
            aboutPara.setText(getString(R.string.arts3));
            facultyPara.setText(getString(R.string.arts3faculties));
        }else if (subDeptName.equals("FASHION DESIGNING")) {
            aboutPara.setText(getString(R.string.arts4));
            facultyPara.setText(getString(R.string.arts4faculties));
        }else if (subDeptName.equals("GEOGRAPHY")) {
            aboutPara.setText(getString(R.string.arts5));
            facultyPara.setText(getString(R.string.arts5faculties));
        }else if (subDeptName.equals("HINDI")) {
            aboutPara.setText(getString(R.string.arts6));
            facultyPara.setText(getString(R.string.arts6faculties));
        }else if (subDeptName.equals("HISTORY")) {
            aboutPara.setText(getString(R.string.arts7));
            facultyPara.setText(getString(R.string.arts7faculties));
        }else if (subDeptName.equals("HOME SCIENCE")) {
            aboutPara.setText(getString(R.string.arts8));
            facultyPara.setText(getString(R.string.arts8faculties));
        }else if (subDeptName.equals("MASS COMMUNICATION")) {
            aboutPara.setText(getString(R.string.arts9));
            facultyPara.setText(getString(R.string.arts9faculties));
        }else if (subDeptName.equals("POLITICAL SCIENCE")) {
            aboutPara.setText(getString(R.string.arts10));
            facultyPara.setText(getString(R.string.arts10faculties));
        }else if (subDeptName.equals("PSYCHOLOGY")) {
            aboutPara.setText(getString(R.string.arts11));
            facultyPara.setText(getString(R.string.arts11faculties));
        }else if (subDeptName.equals("PHILOSOPHY")) {
            aboutPara.setText(getString(R.string.arts12));
            facultyPara.setText(getString(R.string.arts12faculties));
        }else if (subDeptName.equals("SOCIAL WORK")) {
            aboutPara.setText(getString(R.string.arts13));
            facultyPara.setText(getString(R.string.arts13faculties));
        }else if (subDeptName.equals("SOCIOLOGY")) {
            aboutPara.setText(getString(R.string.arts14));
            facultyPara.setText(getString(R.string.arts14faculties));
        }else if (subDeptName.equals("SANSKRIT")) {
            aboutPara.setText(getString(R.string.arts15));
            facultyPara.setText(getString(R.string.arts15faculties));
        }else if (subDeptName.equals("URDU")) {
            aboutPara.setText(getString(R.string.arts16));
            facultyPara.setText(getString(R.string.arts16faculties));
        }
    }
}