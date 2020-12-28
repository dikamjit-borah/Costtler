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

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hobarb.costtler.Adapters.TransactionsTodayAdapter;
import com.hobarb.costtler.Adapters.TransactionsTodayAdapterRVA;
import com.hobarb.costtler.Models.TransactionsTodayModel;
import com.hobarb.costtler.R;
import com.hobarb.costtler.Utilities.BaseActivity;
import com.hobarb.costtler.Utilities.Constants;

import java.util.ArrayList;

public class TransactionsToday extends BaseActivity {
    Toolbar toolbar;
    TextView toolbarText;
    DatabaseReference databaseReference;
RecyclerView recyclerView;
ArrayList<TransactionsTodayModel> transactionsTodayModel;
TransactionsTodayAdapter transactionsTodayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions_today);
        toolbar = findViewById(R.id.tB_custom_ct1);
        setSupportActionBar(toolbar);

        toolbarText = toolbar.findViewById(R.id.tV_activity_ct);
        toolbarText.setText("Transactions Today");
        //toolbar.setTitleTextAppearance(this, R.style.setFont_white);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        recyclerView = findViewById(R.id.rV_tt);

        transactionsTodayModel = new ArrayList<>();

      /*  databaseReference = FirebaseDatabase.getInstance().getReference().child(Constants.USER_PHONE+"/").child(Constants.CURRENT_DATE+"/");*/
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(Constants.USER_PHONE).child(Constants.CURRENT_DATE+"/").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    try{
                        TransactionsTodayModel model = new TransactionsTodayModel(dataSnapshot.child("AMOUNT").getValue().toString(), dataSnapshot.child("DESCRIPTION").getValue().toString());
                        transactionsTodayModel.add(model);
                    }
                    catch (Exception exception)
                    {
                        Toast.makeText(TransactionsToday.this, "" + exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }


                }
               // Toast.makeText(TransactionsToday.this, "Going" , Toast.LENGTH_SHORT).show();
                transactionsTodayAdapter = new TransactionsTodayAdapter(TransactionsToday.this, transactionsTodayModel);
                recyclerView.setLayoutManager(new LinearLayoutManager(TransactionsToday.this));
                recyclerView.setAdapter(transactionsTodayAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(TransactionsToday.this, "" + error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });







     /*   transactionsTodayModel = new ArrayList<>();

        recyclerView = findViewById(R.id.rV_tt);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<TransactionsTodayModel> options
                = new FirebaseRecyclerOptions.Builder<TransactionsTodayModel>()
                .setQuery(databaseReference, TransactionsTodayModel.class)
                .build();
        //Toast.makeText(this, ""+ databaseReference.getKey(), Toast.LENGTH_SHORT).show();
        transactionsTodayAdapterRVA = new TransactionsTodayAdapterRVA(this,options);
        recyclerView.setAdapter(transactionsTodayAdapterRVA);
        transactionsTodayAdapterRVA.startListening();
*/
    }
}