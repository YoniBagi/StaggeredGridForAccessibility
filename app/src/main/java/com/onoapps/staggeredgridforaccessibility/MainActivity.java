package com.onoapps.staggeredgridforaccessibility;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    AdapterStaggeredGrid mAdapterStaggeredGrid;
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    int count;
    int sizeList;
    boolean alreadyRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapterStaggeredGrid = new AdapterStaggeredGrid();
        mRecyclerView = findViewById(R.id.rv);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mRecyclerView.setAdapter(mAdapterStaggeredGrid);
        sizeList = mAdapterStaggeredGrid.getItemCount();
    }
}
