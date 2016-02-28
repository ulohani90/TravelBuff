package com.application.travelbuff.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.travelbuff.R;
import com.application.travelbuff.adapters.FeedListRecyclerViewAdapter;
import com.application.travelbuff.decorators.ListItemDecorator;

/**
 * Created by Umesh Lohani on 2/15/2016.
 */
public class FeedFragment extends BaseFragment {


    RecyclerView feedList;

    public static FeedFragment newInstance(Bundle bundle) {
        FeedFragment fragment = new FeedFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recyclerview_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        feedList = (RecyclerView) view.findViewById(R.id.recyclerview);
        feedList.addItemDecoration(new ListItemDecorator(getActivity().getResources().getDimensionPixelSize(R.dimen.margin_small)));
        feedList.setLayoutManager(new LinearLayoutManager(getActivity()));
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        FeedListRecyclerViewAdapter adapter = new FeedListRecyclerViewAdapter(getActivity(), metrics.heightPixels / 3);
        feedList.setAdapter(adapter);
    }
}
