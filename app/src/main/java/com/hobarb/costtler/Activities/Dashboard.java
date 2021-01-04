package com.hobarb.costtler.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hobarb.costtler.R;
import com.hobarb.costtler.Utilities.Constants;

public class Dashboard extends AppCompatActivity {
    Button btn_add, btn_today, btn_history;
    LinearLayout ll_history, ll_today, ll_monthly, ll_about;
    FloatingActionButton floatingActionButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        String username = getSharedPreferences(Constants.SHARED_PREFS, MODE_PRIVATE).getString(Constants.USER_NAME, "");
        String phone = getSharedPreferences(Constants.SHARED_PREFS, MODE_PRIVATE).getString(Constants.USER_PHONE, "");

        Toolbar toolbar = findViewById(R.id.tB_custom_ct);
        setSupportActionBar(toolbar);
        TextView username_tv = toolbar.findViewById(R.id.tV_username_ct);
        TextView phone_tv = toolbar.findViewById(R.id.tV_phone_ct);

        username_tv.setText(username);
        phone_tv.setText(phone);

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
                startActivity(new Intent(Dashboard.this, History.class));


            }
        });

        ll_today = findViewById(R.id.ll_today_main);
        ll_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TransactionsToday.class));

            }
        });

        ll_monthly = findViewById(R.id.ll_monthly_main);
        ll_monthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Coming Soon!", Toast.LENGTH_SHORT).show();

            }
        });

        ll_about = findViewById(R.id.ll_about_main);
        ll_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://hunkyxstudman.github.io/";
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                // Verify that the intent will resolve to an activity
                if (intent.resolveActivity(getPackageManager()) != null) {
                    // Here we use an intent without a Chooser unlike the next example
                    startActivity(intent);
                }
            }
        });




    }

}