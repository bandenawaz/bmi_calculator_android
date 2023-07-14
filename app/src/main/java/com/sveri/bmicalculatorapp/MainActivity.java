package com.sveri.bmicalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaration
    EditText etHeight, etWeight;
    Button btnCalculate;
    TextView tvMsg;
    ImageView ivResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialisation
        etHeight = findViewById(R.id.editTextHeight);
        etWeight = findViewById(R.id.editTextWeight);
        tvMsg = findViewById(R.id.textViewMessage);
        ivResult = findViewById(R.id.imageViewResult);
        btnCalculate = findViewById(R.id.buttonCalculate);

        //event handler
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String height = etHeight.getText().toString().trim();
                String weight = etWeight.getText().toString().trim();

                //text validation
                //null validation
                if (TextUtils.isEmpty(height)){
                    etHeight.setError("Height cannot be empty");
                    etHeight.requestFocus();
                    return;
                }else if (TextUtils.isEmpty(weight)){
                    etWeight.setError("Weight cannot be empty");
                    etWeight.requestFocus();
                }else {

                    Float wt = Float.parseFloat(weight);
                    Float ht = Float.parseFloat(height) / 100;

                    //lets calculate bmi
                    float bmi = wt / (ht * ht);

                    //lets set the message and pic
                    if (bmi < 18) {

                        tvMsg.setText("Ahhh! You need to Gain Weight");
                        ivResult.setImageResource(R.drawable.under_weight);

                    }
                    if (bmi > 18.5 && bmi < 25) {
                        tvMsg.setText("Wow!!! You're an Fit Guy");
                        ivResult.setImageResource(R.drawable.fit_guy);

                    }
                    if (bmi > 25 ) {

                        tvMsg.setText("Naah!!! You're in Obese Condition");
                        ivResult.setImageResource(R.drawable.obese);
                    }
                }

                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_LONG).show();
                etHeight.setText(null);
                etWeight.setText(null);
            }

        });
    }
}