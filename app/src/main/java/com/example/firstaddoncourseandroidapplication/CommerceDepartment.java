package com.example.firstaddoncourseandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class CommerceDepartment extends AppCompatActivity {

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

        Intent commerceIntent = getIntent();

        String subDeptName = commerceIntent.getStringExtra("subDeptName");

        TextView subDeptHeading = findViewById(R.id.subDeptHeading);

        subDeptHeading.setText(subDeptName);

        TextView aboutPara = findViewById(R.id.aboutPara);
        TextView facultyPara = findViewById(R.id.facultyPara);

        if(subDeptName.equals("BUSINESS ADMINISTRATION (BBA)")){
            aboutPara.setText(getString(R.string.commerce1));
            facultyPara.setText(getString(R.string.commerce1faculties));
        } else if (subDeptName.equals("B.COM")) {
            aboutPara.setText(getString(R.string.commerce2));
            facultyPara.setText(getString(R.string.commerce2faculties));
        }else if (subDeptName.equals("ADVERTISING AND MARKETING MANAGEMENT")) {
            aboutPara.setText(getString(R.string.commerce3));
            facultyPara.setText(getString(R.string.commerce3faculties));
        }else if (subDeptName.equals("B.Ed")) {
            aboutPara.setText(getString(R.string.BEd));
            facultyPara.setText(getString(R.string.BEdFaculties));
        }
    }
}