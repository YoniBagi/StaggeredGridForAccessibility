package com.onoapps.staggeredgridforaccessibility;

import android.support.annotation.NonNull;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Yonatan Bagizada on 29/01/2019.
 */
public class AdapterStaggeredGrid extends RecyclerView.Adapter<AdapterStaggeredGrid.MyViewHolder> {

    int[] imgList = {
            R.drawable.ic_computer,
            R.drawable.ic_delivery,
            R.drawable.ic_graph,
            R.drawable.ic_present,
            R.drawable.ic_shopping,
            R.drawable.ic_stadistics,
            R.drawable.ic_wallet,
            R.drawable.ic_present,
            R.drawable.ic_graph,
            R.drawable.ic_wallet,
            R.drawable.ic_shopping,
            R.drawable.ic_stadistics,
            R.drawable.ic_graph,
            R.drawable.ic_delivery,
            R.drawable.ic_computer,
    };

    String[] nameList = {"One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen"};

    HashMap<Integer, CardView> mCardViewHashMap = new HashMap<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_staggered_grid, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(layoutView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.mImageView.setImageResource(imgList[position]);
        holder.mTextView.setText(nameList[position]);
            mCardViewHashMap.put(position,holder.mCardView);
            if (mCardViewHashMap.size() > 1){
                ViewCompat.setAccessibilityDelegate(mCardViewHashMap.get(position), new AccessibilityDelegateCompat(){
                    @Override
                    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                        super.onInitializeAccessibilityNodeInfo(host, info);
                        info.setTraversalAfter(mCardViewHashMap.get(position-1));
                    }
                });
            }
    }

    @Override
    public int getItemCount() {
        return imgList.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView mImageView;
        public CardView mCardView;
        public MyViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.tvItem);
            mImageView = v.findViewById(R.id.ivItem);
            mCardView = v.findViewById(R.id.cv);
        }
    }
}
