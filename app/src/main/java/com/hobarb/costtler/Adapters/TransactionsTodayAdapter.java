package com.hobarb.costtler.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hobarb.costtler.Activities.TransactionsToday;
import com.hobarb.costtler.Models.TransactionsTodayModel;
import com.hobarb.costtler.R;

import java.util.ArrayList;

public class TransactionsTodayAdapter extends RecyclerView.Adapter<TransactionsTodayAdapter.TransactionsTodayViewHolder>{

    Context context;
    ArrayList<TransactionsTodayModel> transactionsTodayModel;

    public TransactionsTodayAdapter(Context context, ArrayList<TransactionsTodayModel> transactionsTodayModel)
    {

        this.context = context;
        this.transactionsTodayModel = transactionsTodayModel;
        Toast.makeText(context, "Inside  tta" + transactionsTodayModel.size(), Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    public TransactionsTodayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TransactionsTodayViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tt, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionsTodayViewHolder holder, int position) {
        Toast.makeText(context, "" + transactionsTodayModel.get(position).getAMOUNT(), Toast.LENGTH_SHORT).show();
//        holder.tV_time_vh.setText(transactionsTodayModel.get(position).getTime());
        holder.tV_description_vh.setText(transactionsTodayModel.get(position).getDESCRIPTION());
        holder.tV_amount_vh.setText(transactionsTodayModel.get(position).getAMOUNT());

    }

    @Override
    public int getItemCount() {
        return transactionsTodayModel.size();
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
