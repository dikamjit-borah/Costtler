package com.hobarb.costtler.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hobarb.costtler.Adapters.TransactionsTodayAdapter;
import com.hobarb.costtler.Models.TransactionsTodayModel;
import com.hobarb.costtler.R;
import com.hobarb.costtler.Utilities.Constants;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddTransaction extends AppCompatActivity {
    private DatabaseReference mDatabase, databaseReference;
    EditText et_desc, et_amt;
    Button btn_save;
    Toolbar toolbar;
    TextView current_date, current_time;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_transaction);
        setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.tB_custom_ct1);
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextAppearance(this, R.style.setFont_white);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        current_date = findViewById(R.id.tV_currentDate_at);
        current_time = findViewById(R.id.tV_currentTime_at);


        DateTimeFormatter dateFormat = DateTimeFormat
                .forPattern("G,C,Y,x,w,e,E,Y,D,M,d,a,K,h,H,k,m,s,S,z,Z");

        String dob = "2002-01-15";
        LocalTime localTime = new LocalTime();
        LocalDate localDate = new LocalDate();


        SimpleDateFormat dateFormat_x = new SimpleDateFormat("hh:mm:ss");
        Calendar calendar = Calendar.getInstance();

        et_desc = findViewById(R.id.eT_description_at);
        et_amt = findViewById(R.id.eT_amount_at);
        btn_save = findViewById(R.id.btn_save_at);
        FirebaseApp.initializeApp(this);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String username = getSharedPreferences(Constants.SHARED_PREFS, MODE_PRIVATE).getString(Constants.USER_NAME, "");
        String phone = getSharedPreferences(Constants.SHARED_PREFS, MODE_PRIVATE).getString(Constants.USER_PHONE, "");


        Constants.CURRENT_DATE = String.valueOf(localDate);

        try {
            String _24HourTime = localTime.getHourOfDay() +":" + localTime.getMinuteOfHour() ;
            SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
            SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
            Date _24HourDt = _24HourSDF.parse(_24HourTime);
            Constants.CURRENT_TIME = String.valueOf(_12HourSDF.format(_24HourDt));

        } catch (Exception e) {
            e.printStackTrace();
        }

        current_date.setText(Constants.CURRENT_DATE);
        current_time.setText(Constants.CURRENT_TIME);



        //Toast.makeText(this, ""+ localDate, Toast.LENGTH_SHORT).show();
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sh
                        = getSharedPreferences(Constants.SHARED_PREFS,
                        Context.MODE_PRIVATE);
                float amt = sh.getFloat(Constants.TOTAL_AMOUNT_TODAY_SHARED_PREF, 0);
                Toast.makeText(AddTransaction.this, "ttamt" + amt, Toast.LENGTH_SHORT).show();
                Double et_amt_value = Double.parseDouble(et_amt.getText().toString()) + amt;


                mDatabase.child(phone).child(Constants.CURRENT_DATE).child(Constants.TRANSACTIONS_TODAY).child(String.valueOf(Constants.CURRENT_TIME).replace(':', '-')).child(Constants.AMOUNT).setValue(et_amt.getText().toString());
                mDatabase.child(phone).child(Constants.CURRENT_DATE).child(Constants.TRANSACTIONS_TODAY).child(String.valueOf(Constants.CURRENT_TIME).replace(':', '-')).child(Constants.DESCRIPTION).setValue(et_desc.getText().toString());
                mDatabase.child(phone).child(Constants.CURRENT_DATE).child(Constants.TOTAL_AMOUNT_TODAY).setValue(et_amt_value);

                startActivity(new Intent(AddTransaction.this, TransactionsToday.class ));
                finish();


            }
        });

// ...

    }
}