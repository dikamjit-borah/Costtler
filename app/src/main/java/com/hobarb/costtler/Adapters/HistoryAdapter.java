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
        return new HistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.row_history, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.tV_date_vh.setText(HistoryModel.get(position).getDATE());
        holder.tV_totalAmount_vh.setText(HistoryModel.get(position).getTOTAL_AMOUNT());

    }

    @Override
    public int getItemCount() {
        return HistoryModel.size();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder{

        TextView tV_date_vh, tV_totalAmount_vh;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tV_date_vh = itemView.findViewById(R.id.tV_date_history);

            tV_totalAmount_vh = itemView.findViewById(R.id.tV_totalAmount_history);
        }
    }
}
