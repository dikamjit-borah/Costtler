package com.hobarb.costtler.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hobarb.costtler.Adapters.HistoryAdapter;

import com.hobarb.costtler.Models.HistoryModel;
import com.hobarb.costtler.R;
import com.hobarb.costtler.Utilities.Constants;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    Toolbar toolbar;
    TextView toolbarText;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    ArrayList<HistoryModel> historyModels;
    HistoryAdapter historyAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        toolbar = findViewById(R.id.tB_custom_ct1);
        setSupportActionBar(toolbar);

        toolbarText = toolbar.findViewById(R.id.tV_activity_ct);
        toolbarText.setText("History");
        //toolbar.setTitleTextAppearance(this, R.style.setFont_white);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String username = getSharedPreferences(Constants.SHARED_PREFS, MODE_PRIVATE).getString(Constants.USER_NAME, "");
        String phone = getSharedPreferences(Constants.SHARED_PREFS, MODE_PRIVATE).getString(Constants.USER_PHONE, "");


        recyclerView = findViewById(R.id.rV_history);

        historyModels = new ArrayList<>();

        /*  databaseReference = FirebaseDatabase.getInstance().getReference().child(Constants.USER_PHONE+"/").child(Constants.CURRENT_DATE+"/");*/
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(phone).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    try{
                        HistoryModel model = new HistoryModel(dataSnapshot.child(Constants.TOTAL_AMOUNT_TODAY).getValue().toString(), dataSnapshot.getKey().toString());
                        historyModels.add(model);
                    }
                    catch (Exception exception)
                    {
                        Toast.makeText(History.this, "History" + exception.getMessage(), Toast.LENGTH_SHORT).show();
                        return;
                    }


                }
                // Toast.makeText(TransactionsToday.this, "Going" , Toast.LENGTH_SHORT).show();
                historyAdapter = new HistoryAdapter(History.this, historyModels);
                recyclerView.setLayoutManager(new LinearLayoutManager(History.this));
                recyclerView.setAdapter(historyAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(History.this, "" + error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });







    }

}