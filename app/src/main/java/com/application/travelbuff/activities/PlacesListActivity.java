package com.application.travelbuff.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.application.travelbuff.R;
import com.application.travelbuff.adapters.PlacesGridRecyclerAdapter;
import com.application.travelbuff.decorators.ListItemDecorator;

/**
 * Created by Umesh Lohani on 2/27/2016.
 */
public class PlacesListActivity extends BaseActivity {

    RecyclerView placesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_toolbar_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        addToolbarView(toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        placesList = (RecyclerView) findViewById(R.id.recyclerview);
        placesList.setLayoutManager(new LinearLayoutManager(this));
        placesList.addItemDecoration(new ListItemDecorator(getResources().getDimensionPixelSize(R.dimen.margin_mini)));
        setAdapterData();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void setAdapterData() {
        int height = 1 * (getDisplayMetrics().heightPixels - getResources().getDimensionPixelSize(R.dimen.abc_action_bar_default_height_material)) / 3;
        PlacesGridRecyclerAdapter adapter = new PlacesGridRecyclerAdapter(this, height);
        placesList.setAdapter(adapter);
    }


    public void addToolbarView(Toolbar toolbar) {
        View view = LayoutInflater.from(this).inflate(R.layout.toolbar_search_layout, toolbar, false);
        toolbar.addView(view);
    }
}
