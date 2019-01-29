package com.onoapps.staggeredgridforaccessibility;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Yonatan Bagizada on 29/01/2019.
 */
public class AdapterStaggeredGrid extends RecyclerView.Adapter<AdapterStaggeredGrid.MyViewHolder> {

    int[] imgList = {R.drawable.ic_computer,
            R.drawable.ic_delivery,
            R.drawable.ic_graph,
            R.drawable.ic_present,
            R.drawable.ic_shopping,
            R.drawable.ic_stadistics,
            R.drawable.ic_wallet
    };

    String[] nameList = {"One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten"};

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_staggered_grid, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(layoutView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mImageView.setImageResource(imgList[position]);
        holder.mTextView.setText(nameList[position]);
    }

    @Override
    public int getItemCount() {
        return imgList.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView mImageView;
        public MyViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.tvItem);
            mImageView = v.findViewById(R.id.ivItem);
        }
    }
}
