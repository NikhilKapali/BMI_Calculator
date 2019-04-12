package com.example.bmi_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed_height, ed_weight, ed_bmi;
    Button compute;
    Double height, weight, bmi, getHeightInMeters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compute = findViewById(R.id.btn_BMI);
        ed_bmi = findViewById(R.id.ed_BMI);
        ed_height = findViewById(R.id.ed_height);
        ed_weight = findViewById(R.id.ed_weight);

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height = Double.parseDouble(ed_height.getText().toString());
                weight = Double.parseDouble(ed_weight.getText().toString());
                getHeightInMeters= height/100;
                bmi = weight / (getHeightInMeters * getHeightInMeters) ;
                ed_bmi.setText(bmi.toString());

                if(bmi < 18.5) {

                    Toast.makeText(MainActivity.this,
                            "You are under weight : " + bmi.toString(),
                            Toast.LENGTH_LONG).show();
                }
                if(bmi > 18.5 && bmi < 24.9) {

                    Toast.makeText(MainActivity.this,
                            "You are weight is average : " + bmi.toString(),
                            Toast.LENGTH_LONG).show();
                }
                if(bmi > 25 && bmi < 29.9 ) {

                    Toast.makeText(MainActivity.this,
                            "You are over weight : " + bmi.toString(),
                            Toast.LENGTH_LONG).show();
                }
                if(bmi > 30) {

                    Toast.makeText(MainActivity.this,
                            "You are obsesive : " + bmi.toString(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
