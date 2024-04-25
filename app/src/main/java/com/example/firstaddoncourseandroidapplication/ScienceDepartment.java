package com.example.firstaddoncourseandroidapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ScienceDepartment extends AppCompatActivity {

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

        Intent scienceIntent = getIntent();

        String subDeptName = scienceIntent.getStringExtra("subDeptName");

        TextView subDeptHeading = findViewById(R.id.subDeptHeading);

        subDeptHeading.setText(subDeptName);

        TextView aboutPara = findViewById(R.id.aboutPara);
        TextView facultyPara = findViewById(R.id.facultyPara);

        if(subDeptName.equals("COMPUTER APPLICATIONS (MCA)")){
            aboutPara.setText(getString(R.string.science1mca));
            facultyPara.setText(getString(R.string.science1mcafaculties));
        } else if (subDeptName.equals("COMPUTER APPLICATIONS (BCA)")) {
            aboutPara.setText(getString(R.string.science1bca));
            facultyPara.setText(getString(R.string.science1bcafaculties));
        }else if (subDeptName.equals("BIOTECHNOLOGY")) {
            aboutPara.setText(getString(R.string.science2));
            facultyPara.setText(getString(R.string.science2faculties));
        }else if (subDeptName.equals("BOTANY")) {
            aboutPara.setText(getString(R.string.science3));
            facultyPara.setText(getString(R.string.science3faculties));
        }else if (subDeptName.equals("CHEMISTRY")) {
            aboutPara.setText(getString(R.string.science4));
            facultyPara.setText(getString(R.string.science4faculties));
        }else if (subDeptName.equals("MATHEMATICS")) {
            aboutPara.setText(getString(R.string.science5));
            facultyPara.setText(getString(R.string.science5faculties));
        }else if (subDeptName.equals("MICROBIOLOGY")) {
            aboutPara.setText(getString(R.string.science6));
            facultyPara.setText(getString(R.string.science6faculties));
        }else if (subDeptName.equals("PHYSICS")) {
            aboutPara.setText(getString(R.string.science7));
            facultyPara.setText(getString(R.string.science7faculties));
        }else if (subDeptName.equals("STATISTICS")) {
            aboutPara.setText(getString(R.string.science8));
            facultyPara.setText(getString(R.string.science8faculties));
        }else if (subDeptName.equals("ZOOLOGY")) {
            aboutPara.setText(getString(R.string.science9));
            facultyPara.setText(getString(R.string.science9faculties));
        }
    }
}