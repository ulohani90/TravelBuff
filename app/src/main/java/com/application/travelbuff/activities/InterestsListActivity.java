package com.application.travelbuff.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.application.travelbuff.R;
import com.application.travelbuff.adapters.InterestsListAdapter;
import com.application.travelbuff.decorators.ListItemDecorator;

/**
 * Created by Umesh Lohani on 2/28/2016.
 */
public class InterestsListActivity extends BaseActivity {

    RecyclerView interestsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_toolbar_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        addToolbarView(toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        interestsList = (RecyclerView) findViewById(R.id.recyclerview);
        interestsList.setLayoutManager(new LinearLayoutManager(this));
        interestsList.addItemDecoration(new ListItemDecorator(getResources().getDimensionPixelSize(R.dimen.margin_mini)));
        setAdapterData();
    }


    public void addToolbarView(Toolbar toolbar) {
        View view = LayoutInflater.from(this).inflate(R.layout.toolbar_search_layout, toolbar, false);
        toolbar.addView(view);
    }


    public void setAdapterData() {
        int height = 1 * (getDisplayMetrics().heightPixels - getResources().getDimensionPixelSize(R.dimen.abc_action_bar_default_height_material)) / 3;
        InterestsListAdapter adapter = new InterestsListAdapter(this, height);
        interestsList.setAdapter(adapter);
    }
}
