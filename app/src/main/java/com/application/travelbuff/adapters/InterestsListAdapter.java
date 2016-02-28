package com.application.travelbuff.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.travelbuff.R;
import com.application.travelbuff.utils.CommonLib;

/**
 * Created by Umesh Lohani on 2/28/2016.
 */
public class InterestsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    boolean isFooterRemoved;

    int TYPE_INTEREST = 0;

    int TYPE_LOADER = 1;

    int height;

    public InterestsListAdapter(Context context, int height) {
        this.context = context;
        this.height = height;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1 && !isFooterRemoved) {
            return TYPE_LOADER;
        } else {
            return TYPE_INTEREST;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        if (viewType == TYPE_INTEREST) {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.places_grid_item_layout, parent, false);
            holder = new PlacesViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.progress_footer_layout, parent, false);
            holder = new LoadingViewHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_INTEREST) {
            PlacesViewHolder holderPlace = (PlacesViewHolder) holder;
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, height);
            holderPlace.placeImage.setLayoutParams(lp);
            holderPlace.placeImage.setImageBitmap(CommonLib.getBitmap(context, R.drawable.interets_dummy, height, height));
            holderPlace.placeName.setText("Biking");
        }
    }

    @Override
    public int getItemCount() {
        return 20 + 1;
    }

    public class PlacesViewHolder extends RecyclerView.ViewHolder {
        ImageView placeImage;
        TextView placeName;
        FrameLayout parent;

        public PlacesViewHolder(View view) {
            super(view);
            placeImage = (ImageView) itemView.findViewById(R.id.place_img);
            placeName = (TextView) itemView.findViewById(R.id.place_name);
            parent = (FrameLayout) itemView.findViewById(R.id.parent_layout);
        }

    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder {

        public LoadingViewHolder(View view) {
            super(view);

        }

    }

}
