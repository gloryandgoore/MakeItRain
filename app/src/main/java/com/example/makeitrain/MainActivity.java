package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button makeItRain;
    private  Button showInfo;
    private TextView moneyValue;
    private int moneyCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeItRain = findViewById(R.id.buttonMakeItRain);
        showInfo = findViewById(R.id.buttonShowInfo);
        moneyValue = findViewById(R.id.moneyValue);

        makeItRain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity","onClick: Make it Rain");
                showMoney();

            }
        });

        showInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity","onClick: Show Info");
                showInfo();

            }
        });
    }

    public void showMoney(){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyCounter += 1000;
        moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter)));
        //my way
//        if (moneyCounter > 20000){
//            moneyValue.setTextColor(getResources().getColor(R.color.purple_700));
//            Snackbar.make(moneyValue, "You're Getting Rich!", Snackbar.LENGTH_SHORT)
//                    .show();
//
//        }
        //better option
        switch (moneyCounter){
            case 20000:
                moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.purple_200));
                break;
            case 30000:
                moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.purple_500));
                break;
        }
    }

    public void showInfo(){
        //Toast
//        Toast.makeText(MainActivity.this, R.string.app_name, Toast.LENGTH_SHORT).show();
//Snackbar
        Snackbar.make(moneyValue, R.string.app_name, Snackbar.LENGTH_SHORT)
                .setAction("More", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
                        moneyCounter -= 1000;
                        moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter)));

                    }
                })
                .show();
    }
}