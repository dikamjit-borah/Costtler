package com.hobarb.costtler;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hobarb.costtler.Activities.Dashboard;
import com.hobarb.costtler.Utilities.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onFirstRun();


    }
    public void onFirstRun(){

        boolean ifFirstRun = getSharedPreferences(Constants.SHARED_PREFS, MODE_PRIVATE).getBoolean(Constants.IF_FIRST_RUN, true);

        if(ifFirstRun)
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            final View customLayout = getLayoutInflater().inflate(R.layout.custom_dialog, null);
            builder.setView(customLayout);
            builder.setCancelable(false);
            builder.setTitle("USER DETAILS");
            builder.setMessage("Enter User Details");
            builder.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    EditText username = customLayout.findViewById(R.id.eT_username_cd);
                    EditText phone = customLayout.findViewById(R.id.eT_phone_cd);
                    if(username.getText().toString().equals("") || phone.getText().toString().equals(""))
                    {
                        Toast.makeText(MainActivity.this, "Enter Details", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "1" + username.getText().toString(), Toast.LENGTH_SHORT).show();
                        getSharedPreferences(Constants.SHARED_PREFS, MODE_PRIVATE).edit().putBoolean(Constants.IF_FIRST_RUN, false).apply();
                        getSharedPreferences(Constants.SHARED_PREFS, MODE_PRIVATE).edit().putString(Constants.USER_NAME, username.getText().toString()).apply();
                        getSharedPreferences(Constants.SHARED_PREFS, MODE_PRIVATE).edit().putString(Constants.USER_PHONE, phone.getText().toString()).apply();


                        startActivity(new Intent(MainActivity.this, Dashboard.class));
                        finish();
                    }

                }
            });

            builder.show();
        }
        else {
            startActivity(new Intent(MainActivity.this, Dashboard.class));
            finish();
        }

    }
}