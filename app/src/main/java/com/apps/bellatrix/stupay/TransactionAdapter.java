package com.apps.bellatrix.stupay;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TransactionAdapter  extends RecyclerView.Adapter<TransactionAdapter.THolder>{

    ArrayList<Transaction> list;
    Context context;

    public TransactionAdapter(ArrayList<Transaction> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public THolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new THolder(LayoutInflater.from(context).inflate(R.layout.single_row_transaction, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull THolder holder, int position) {
        holder.tvAmount.setText(String.valueOf(list.get(position).amount));
        holder.tvPurpose.setText(String.valueOf(list.get(position).purpose));

        if(list.get(position).increment){
            holder.ivIncOrDec.setImageDrawable(context.getDrawable(android.R.drawable.arrow_up_float));
            holder.ivIncOrDec.setBackgroundColor(context.getResources().getColor(android.R.color.holo_green_light));
        } else {
            holder.ivIncOrDec.setImageDrawable(context.getDrawable(android.R.drawable.arrow_down_float));
            holder.ivIncOrDec.setBackgroundColor(context.getResources().getColor(android.R.color.holo_red_light));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class THolder extends RecyclerView.ViewHolder{

        TextView tvPurpose, tvAmount;
        ImageView ivIncOrDec;

        public THolder(@NonNull View itemView) {
            super(itemView);

            tvAmount = itemView.findViewById(R.id.tvAmount);
            tvPurpose = itemView.findViewById(R.id.tvPurpose);
            ivIncOrDec = itemView.findViewById(R.id.ivIncOrDec);
        }
    }
}
