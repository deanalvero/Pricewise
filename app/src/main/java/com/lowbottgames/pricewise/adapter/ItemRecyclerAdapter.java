package com.lowbottgames.pricewise.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.lowbottgames.pricewise.R;
import com.lowbottgames.pricewise.model.PItem;

import java.util.ArrayList;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ViewHolder>{

    private ItemRecyclerAdapter.OnItemClickListener listener;
    private ArrayList<PItem> itemList;

    public ItemRecyclerAdapter(ArrayList<PItem> itemList){
        this.itemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_pitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        PItem item = itemList.get(position);

        holder.textViewEquation.setText(String.format("%f / %f", item.getPrice(), item.getUnit()));
        holder.textViewAnswer.setText(String.format("%f", item.getRatio()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onItemClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (itemList == null) return 0;
        return itemList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
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
