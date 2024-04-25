package com.example.firstaddoncourseandroidapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

public class MainActivity extends AppCompatActivity {

    private Spinner languageSpinner;
    private Button submitBtn;

    private String selectedKey;

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });

        languageSpinner = findViewById(R.id.languages);

        Map<String, String> langWithCodes = new HashMap<>();
        langWithCodes.put("English", "en");
        langWithCodes.put("Hindi", "hi");
        langWithCodes.put("Urdu", "ur");
        langWithCodes.put("Bengali", "bn");
        langWithCodes.put("Tamil", "ta");
        langWithCodes.put("Telugu", "te");
        langWithCodes.put("Kannada", "kn");
        langWithCodes.put("Marathi", "mr");
        langWithCodes.put("Gujarati", "gu");

        String[] langKeys = langWithCodes.keySet().toArray(new String[0]);


        ArrayAdapter<String> languagesAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                langKeys
        );

        languagesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        languageSpinner.setAdapter(languagesAdapter);


        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedKey = languageSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Choose the language", Toast.LENGTH_SHORT).show();
            }
        });

        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editName = findViewById(R.id.editName);
                TextView welcomeTxt = findViewById(R.id.welcomeTxt);

                TranslatorOptions options = new TranslatorOptions.Builder()
                        .setTargetLanguage(langWithCodes.get(selectedKey))
                        .setSourceLanguage("en")
                        .build();

                Translator translator = Translation.getClient(options);
                translator.downloadModelIfNeeded();
                String sourceTxt = "Welcome " + editName.getText().toString();
                translator.translate(sourceTxt).addOnSuccessListener(new OnSuccessListener<String>() {
                    @Override
                    public void onSuccess(String s) {
                        welcomeTxt.setText(s);
                        tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Not working", Toast.LENGTH_SHORT).show();
                    }
                });

                Intent deptIntent = new Intent(MainActivity.this, Department.class);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(deptIntent);
                    }
                }, 5000);
            }
        });

    }

}