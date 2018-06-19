package com.example.lk.customrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recycleviewlibrary.RecycleViewDivider;
import com.example.recycleviewlibrary.YRecycleView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private YRecycleView yRecycleView;
    private List<String> list = new ArrayList<>();
    private YRAdapter yrAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initdata();
    }

    private void initdata() {
        for (int i = 0; i < 30; i++) {
            list.add("" + i);
        }

        yRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        yRecycleView.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.VERTICAL));
        yrAdapter = new YRAdapter(this, list);
        yRecycleView.setAdapter(yrAdapter);
        yRecycleView.setRefreshAndLoadMoreListener(new YRecycleView.OnRefreshAndLoadMoreListener() {
            @Override
            public void onRefresh() {
                for (int i = 30; i < 40; i++) {
                    list.add("" + i);
                }
                yrAdapter.notifyDataSetChanged();

                yRecycleView.setReFreshComplete();

            }

            @Override
            public void onLoadMore() {
                for (int i = 50; i < 60; i++) {
                    list.add("" + i);
                }
                yrAdapter.notifyDataSetChanged();
                yRecycleView.setloadMoreComplete();
            }
        });
    }

    private void initview() {
        yRecycleView = findViewById(R.id.yrv);
    }
}
