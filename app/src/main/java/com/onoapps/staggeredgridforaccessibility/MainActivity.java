package com.onoapps.staggeredgridforaccessibility;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    AdapterStaggeredGrid mAdapterStaggeredGrid;
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mAdapterStaggeredGrid = new AdapterStaggeredGrid();
        mRecyclerView.setAdapter(mAdapterStaggeredGrid);

    }
}
