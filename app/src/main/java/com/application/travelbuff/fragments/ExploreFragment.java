package com.application.travelbuff.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.travelbuff.R;
import com.application.travelbuff.adapters.ExploreAdapter;
import com.application.travelbuff.decorators.ExploreFragmentItemDecorator;

/**
 * Created by Umesh Lohani on 2/23/2016.
 */
public class ExploreFragment extends BaseFragment {

    public static ExploreFragment newInstance(Bundle bundle) {
        ExploreFragment fragment = new ExploreFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    RecyclerView exploreList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recyclerview_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        exploreList = (RecyclerView) view.findViewById(R.id.recyclerview);
        exploreList.addItemDecoration(new ExploreFragmentItemDecorator(getActivity().getResources().getDimensionPixelSize(R.dimen.margin_small)));
        exploreList.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        ExploreAdapter adapter = new ExploreAdapter(getActivity(), (metrics.widthPixels / 2 - 3 * getResources().getDimensionPixelSize(R.dimen.margin_small)));
        ((GridLayoutManager) exploreList.getLayoutManager()).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (exploreList.getAdapter().getItemViewType(position) == 0 || exploreList.getAdapter().getItemViewType(position) == 1 || exploreList.getAdapter().getItemViewType(position) == 2) {
                    return 2;
                } else {
                    return 1;
                }

            }
        });
        exploreList.setAdapter(adapter);
    }
}
