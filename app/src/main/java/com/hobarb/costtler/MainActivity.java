package com.hobarb.costtler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hobarb.costtler.Activities.AddTransaction;
import com.hobarb.costtler.Activities.History;
import com.hobarb.costtler.Activities.TransactionsToday;

public class MainActivity extends AppCompatActivity {
    Button btn_add, btn_today, btn_history;
    LinearLayout ll_history, ll_today;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton = findViewById(R.id.fab_add_main);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddTransaction.class));
            }
        });


        ll_history = findViewById(R.id.ll_history_main);
        ll_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, History.class));


            }
        });

        ll_today = findViewById(R.id.ll_today_main);
        ll_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TransactionsToday.class));

            }
        });

    }
}