package com.lowbottgames.pricewise.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lowbottgames.pricewise.R;
import com.lowbottgames.pricewise.model.PItem;

import java.util.ArrayList;

/**
 * Created by Dean on 12/13/2015.
 */
public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ViewHolder>{

    private ArrayList<PItem> itemList;

    public ItemRecyclerAdapter(ArrayList<PItem> itemList){
        this.itemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_pitem, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PItem item = itemList.get((itemList.size() - 1) - position);

        holder.textViewEquation.setText(String.format("%f / %f", item.getPrice(), item.getUnit()));
        holder.textViewAnswer.setText(String.format("%f", item.getRatio()));
    }

    @Override
    public int getItemCount() {
        if (itemList == null) return 0;
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewEquation, textViewAnswer;

        public ViewHolder(final View itemView) {
            super(itemView);

            textViewEquation = (TextView) itemView.findViewById(R.id.textView_equation);
            textViewAnswer = (TextView) itemView.findViewById(R.id.textView_answer);
        }
    }
}