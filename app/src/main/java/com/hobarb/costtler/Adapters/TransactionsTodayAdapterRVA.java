package com.hobarb.costtler.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseListOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.hobarb.costtler.Models.TransactionsTodayModel;
import com.hobarb.costtler.R;

import java.util.ArrayList;

public class TransactionsTodayAdapterRVA extends FirebaseRecyclerAdapter<
        TransactionsTodayModel, TransactionsTodayAdapterRVA.TransactionsTodayViewHolder> {

    Context context;



    public TransactionsTodayAdapterRVA(Context context, FirebaseRecyclerOptions<TransactionsTodayModel> options) {
        super(options);
        this.context = context;
    }

    @NonNull
    @Override
    public TransactionsTodayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TransactionsTodayViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tt, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionsTodayViewHolder holder, int position, @NonNull TransactionsTodayModel model) {
       // holder.tV_time_vh.setText(model.getTime());
        holder.tV_description_vh.setText(model.getDESCRIPTION());
        Toast.makeText(context, "yoyo" +model.getAMOUNT(), Toast.LENGTH_SHORT).show();
        holder.tV_amount_vh.setText(model.getAMOUNT());

    }

    class TransactionsTodayViewHolder extends RecyclerView.ViewHolder{

        TextView tV_time_vh, tV_amount_vh, tV_description_vh;

        public TransactionsTodayViewHolder(@NonNull View itemView) {
            super(itemView);
            tV_time_vh = itemView.findViewById(R.id.tV_time_rtt);
            tV_description_vh = itemView.findViewById(R.id.tV_description_rtt);
            tV_amount_vh = itemView.findViewById(R.id.tV_amount_rtt);
        }
    }
}
