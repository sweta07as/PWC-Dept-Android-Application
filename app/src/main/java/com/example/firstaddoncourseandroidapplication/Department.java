package com.example.firstaddoncourseandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Department extends AppCompatActivity {

    private Button viewDetailsBtn;

    private Spinner deptSpinner;

    private Spinner subDeptSpinner;

    private String[] subDeptArray;

    private String selectedDept;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        deptSpinner = findViewById(R.id.departments);
        subDeptSpinner = findViewById(R.id.subDepartments);

        String[] deptArray = {"Select Your Department", "ARTS", "SCIENCE", "COMMERCE", "B.Ed"};

        ArrayAdapter<String> deptAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                deptArray
        );

        deptAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        deptSpinner.setAdapter(deptAdapter);

        subDeptArray = new String[]{"Select Your Sub-Department"};

        ArrayAdapter<String> subDeptAdapter = new ArrayAdapter<>(Department.this,
                android.R.layout.simple_spinner_item,
                subDeptArray
        );

        subDeptAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        subDeptSpinner.setAdapter(subDeptAdapter);


        Intent artsIntent = new Intent(Department.this, ArtsDepartment.class);
        Intent scienceIntent = new Intent(Department.this, ScienceDepartment.class);
        Intent commerceIntent = new Intent(Department.this, CommerceDepartment.class);


        deptSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selectedDept = deptSpinner.getSelectedItem().toString();

                if (deptSpinner.getSelectedItem().toString().equals("Select Your Department")) {
                    subDeptArray = new String[]{"Select Your Sub-Department"};
                    fillSpinner();
//                    Toast.makeText(Department.this, "Select your department", Toast.LENGTH_SHORT).show();
                } else if (deptSpinner.getSelectedItem().toString().equals("ARTS")) {
                    subDeptArray = new String[]{"Select Your Sub-Department", "COMMUNICATIVE ENGLISH AND MEDIA STUDIES", "ENGLISH",
                            "ECONOMICS", "FASHION DESIGNING", "GEOGRAPHY", "HINDI", "HISTORY",
                            "HOME SCIENCE", "MASS COMMUNICATION", "POLITICAL SCIENCE", "PSYCHOLOGY",
                            "PHILOSOPHY", "SOCIAL WORK", "SOCIOLOGY", "SANSKRIT", "URDU"};
                    fillSpinner();

                } else if (deptSpinner.getSelectedItem().toString().equals("SCIENCE")) {
                    subDeptArray = new String[]{"Select Your Sub-Department", "COMPUTER APPLICATIONS (MCA)",
                            "COMPUTER APPLICATIONS (BCA)", "BIOTECHNOLOGY", "BOTANY", "CHEMISTRY", "MATHEMATICS", "MICROBIOLOGY",
                            "PHYSICS", "STATISTICS", "ZOOLOGY"};
                    fillSpinner();
                } else if (deptSpinner.getSelectedItem().toString().equals("COMMERCE")) {
                    subDeptArray = new String[]{"Select Your Sub-Department", "BUSINESS ADMINISTRATION (BBA)",
                            "B.COM", "ADVERTISING AND MARKETING MANAGEMENT"};
                    fillSpinner();
                } else if (deptSpinner.getSelectedItem().toString().equals("B.Ed")) {
                    subDeptArray = new String[]{"Select Your Sub-Department"};
                    fillSpinner();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Department.this, "Select your department", Toast.LENGTH_SHORT).show();
            }
        });



        subDeptSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(selectedDept.equals("ARTS")){
                    artsIntent.putExtra("subDeptName", subDeptSpinner.getSelectedItem().toString());
                } else if (selectedDept.equals("SCIENCE")) {
                    scienceIntent.putExtra("subDeptName", subDeptSpinner.getSelectedItem().toString());
                }else if (selectedDept.equals("COMMERCE")) {
                    commerceIntent.putExtra("subDeptName", subDeptSpinner.getSelectedItem().toString());
                }else if (selectedDept.equals("B.Ed")) {
                    commerceIntent.putExtra("subDeptName", "B.Ed");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Department.this, "Select your sub-department", Toast.LENGTH_SHORT).show();
            }
        });

        viewDetailsBtn = findViewById(R.id.viewDetailsBtn);

        viewDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedDept.equals("ARTS")){
                    startActivity(artsIntent);
                } else if (selectedDept.equals("SCIENCE")) {
                    startActivity(scienceIntent);
                }else if (selectedDept.equals("COMMERCE") || selectedDept.equals("B.Ed")) {
                    startActivity(commerceIntent);
                }
            }
        });
    }

    public void fillSpinner() {
        ArrayAdapter<String> subDeptAdapter = new ArrayAdapter<>(Department.this,
                android.R.layout.simple_spinner_item,
                subDeptArray
        );
        subDeptAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subDeptSpinner.setAdapter(subDeptAdapter);
    }


}