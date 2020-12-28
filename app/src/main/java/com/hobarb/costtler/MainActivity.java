package com.hobarb.costtler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hobarb.costtler.Activities.AddTransaction;
import com.hobarb.costtler.Activities.TransactionsToday;

public class MainActivity extends AppCompatActivity {
    Button btn_add, btn_today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_add = findViewById(R.id.btn_add_main);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddTransaction.class));
            }
        });

        btn_today = findViewById(R.id.btn_today_main);
        btn_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TransactionsToday.class));
            }
        });
    }
}