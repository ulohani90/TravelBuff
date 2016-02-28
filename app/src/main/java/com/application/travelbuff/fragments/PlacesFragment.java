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
import com.application.travelbuff.adapters.PlacesGridRecyclerAdapter;
import com.application.travelbuff.decorators.GridItemDecorator;

/**
 * Created by Umesh Lohani on 2/15/2016.
 */
public class PlacesFragment extends BaseFragment {


    RecyclerView placesList;

    public static PlacesFragment newInstance(Bundle bundle) {
        PlacesFragment fragment = new PlacesFragment();
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
        placesList = (RecyclerView) view.findViewById(R.id.recyclerview);
        placesList.addItemDecoration(new GridItemDecorator(getActivity().getResources().getDimensionPixelSize(R.dimen.margin_small)));
        placesList.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        PlacesGridRecyclerAdapter adapter = new PlacesGridRecyclerAdapter(getActivity(), (metrics.widthPixels / 2 - 3 * getResources().getDimensionPixelSize(R.dimen.margin_small)));
        ((GridLayoutManager) placesList.getLayoutManager()).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (placesList.getAdapter().getItemViewType(position) == 0) {
                    return 1;
                } else {
                    return 2;
                }

            }
        });
        placesList.setAdapter(adapter);
    }
}
