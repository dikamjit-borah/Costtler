package com.hobarb.costtler.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hobarb.costtler.Models.HistoryModel;
import com.hobarb.costtler.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>{

    Context context;
    ArrayList<HistoryModel> HistoryModel;

    public HistoryAdapter(Context context, ArrayList<HistoryModel> HistoryModel)
    {

        this.context = context;
        this.HistoryModel = HistoryModel;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tt, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        Toast.makeText(context, "" + HistoryModel.get(position).getAMOUNT(), Toast.LENGTH_SHORT).show();
        holder.tV_time_vh.setText(HistoryModel.get(position).getTIME());
        holder.tV_description_vh.setText(HistoryModel.get(position).getDESCRIPTION());
        holder.tV_amount_vh.setText(HistoryModel.get(position).getAMOUNT());

    }

    @Override
    public int getItemCount() {
        return HistoryModel.size();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder{

        TextView tV_time_vh, tV_amount_vh, tV_description_vh;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tV_time_vh = itemView.findViewById(R.id.tV_time_rtt);
            tV_description_vh = itemView.findViewById(R.id.tV_description_rtt);
            tV_amount_vh = itemView.findViewById(R.id.tV_amount_rtt);
        }
    }
}
