package com.androidwavelength.compapp;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.MissingResourceException;


public class MainActivity extends AppCompatActivity {
    private LinearLayout Container;
    private ArrayList<EditText>editTexts;
    private Button btnPlus, btnMinus, btnSum, btnDifference;
    private TextView ResultTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTexts = new ArrayList<EditText>();

        initViews();
        setupListener();


    }
    private void initViews () {
        Container = findViewById(R.id.container);
        ResultTxt = findViewById(R.id.ResultTxt);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnSum = findViewById(R.id.btnSum);
        btnDifference = findViewById(R.id.btnDifference);

    }
    private void setupListener () {
        btnPlus.setOnClickListener(new BtnOnClickListener());
        btnMinus.setOnClickListener(new BtnOnClickListener());
    }

    private class BtnOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int count = 0;
            LinearLayout.LayoutParams layoutParams =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );

            EditText edt = new EditText(MainActivity.this);
            edt.setLayoutParams(layoutParams);
            edt.setHint("Enter Number");
            edt.setBackgroundColor(Color.WHITE);
            if (view == btnPlus) {
                editTexts.add(edt);
                Container.addView(edt);
                count++;

            } else if (view == btnMinus) {
                Container.removeView(editTexts.get(count));
                editTexts.remove(count);
                count--;

            } else if (view == btnSum){

            }
        }
    }

}