package com.example.simpliedtipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private double billAmount = 0;
    private double percentage = 15;
    private double tip = 0;
    private double total = 0;
    private EditText etTotal, etTip;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIncrease = findViewById(R.id.btnIncrease);
        Button btnDecrease = findViewById(R.id.btnDecrease);
        EditText etBillAmount  = findViewById(R.id.etBillAmount);
        EditText etPercentage  = findViewById(R.id.etPercentage);
        etTip  = findViewById(R.id.etTip);
        etTotal  = findViewById(R.id.etTotal);

        etPercentage.setText(percentage + " %");

        etBillAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!TextUtils.isEmpty(s)) {
                    billAmount = Double.parseDouble(s.toString());

                    calculateTotal();
                } else {
                    etTip.setText("");
                    etTotal.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percentage ++;
                etPercentage.setText(percentage + " %");

                calculateTotal();

            }
        });

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percentage --;
                etPercentage.setText(percentage + " %");

                calculateTotal();

            }
        });





    }

    private void calculateTotal() {


            double tip = (billAmount * percentage)/100;
            etTip.setText(String.valueOf(tip));
            etTotal.setText(String.valueOf(tip+billAmount));


        }


}