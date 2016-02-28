package com.application.travelbuff.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.application.travelbuff.R;
import com.application.travelbuff.activities.InterestsListActivity;
import com.application.travelbuff.activities.PlacesListActivity;
import com.application.travelbuff.utils.CommonLib;

/**
 * Created by Umesh Lohani on 2/23/2016.
 */
public class ExploreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;

    int TYPE_HEADER_PLACES = 0;

    int TYPE_HEADER_PEOPLE = 1;

    int TYPE_HEADER_INTERESTS = 2;

    int TYPE_PLACES_DATA = 3;

    int TYPE_PEOPLE_DATA = 4;

    int TYPE_INTERESTS_DATA = 5;

    int width;

    public ExploreAdapter(Context context, int width) {
        this.mContext = context;
        this.width = width;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        if (viewType == TYPE_HEADER_INTERESTS || viewType == TYPE_HEADER_PLACES || viewType == TYPE_HEADER_PEOPLE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.explore_fragment_header_layout, parent, false);
            holder = new HeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.explore_fragment_item_layout, parent, false);
            holder = new DataViewHolder(view);
        }


        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER_PLACES) {
            ((HeaderViewHolder) holder).headerLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, PlacesListActivity.class);
                    mContext.startActivity(intent);
                }
            });
            ((HeaderViewHolder) holder).headerText.setText("Places (497)");
        } else if (getItemViewType(position) == TYPE_HEADER_INTERESTS) {
            ((HeaderViewHolder) holder).headerLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, InterestsListActivity.class);
                    mContext.startActivity(intent);
                }
            });
            ((HeaderViewHolder) holder).headerText.setText("Interests (53)");
        } else if (getItemViewType(position) == TYPE_HEADER_PEOPLE) {
            ((HeaderViewHolder) holder).headerText.setText("People (29002)");
        } else if (getItemViewType(position) == TYPE_PLACES_DATA) {
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, width);
            ((DataViewHolder) holder).parent.setLayoutParams(lp);
            ((DataViewHolder) holder).image.setImageBitmap(CommonLib.getBitmap(mContext, R.drawable.place_dummy, width, width));
            ((DataViewHolder) holder).name.setText("Himachal Pradesh");
        } else if (getItemViewType(position) == TYPE_INTERESTS_DATA) {
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, width);
            ((DataViewHolder) holder).parent.setLayoutParams(lp);

            ((DataViewHolder) holder).image.setImageBitmap(CommonLib.getBitmap(mContext, R.drawable.interets_dummy, width, width));
            ((DataViewHolder) holder).name.setText("Biking");
        } else {
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, width);
            ((DataViewHolder) holder).parent.setLayoutParams(lp);

            ((DataViewHolder) holder).image.setImageBitmap(CommonLib.getBitmap(mContext, R.drawable.user_dummy_img, width, width));
            ((DataViewHolder) holder).name.setText("Umesh Lohani");
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER_PLACES;
        } else if (position == 1 || position == 2 || position == 3 || position == 4) {
            return TYPE_PLACES_DATA;
        } else if (position == 5) {
            return TYPE_HEADER_INTERESTS;
        } else if (position == 6 || position == 7 || position == 8 || position == 9) {
            return TYPE_INTERESTS_DATA;
        } else if (position == 10) {
            return TYPE_HEADER_PEOPLE;
        } else {
            return TYPE_PEOPLE_DATA;
        }
    }

    @Override
    public int getItemCount() {
        return 15;
    }


    public class DataViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;

        FrameLayout parent;

        public DataViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
            parent = (FrameLayout) itemView.findViewById(R.id.parent);
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        TextView headerText, seeAllBtn;
        LinearLayout headerLayout;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            headerText = (TextView) itemView.findViewById(R.id.heading_text);
            seeAllBtn = (TextView) itemView.findViewById(R.id.see_all);
            headerLayout = (LinearLayout) itemView.findViewById(R.id.parent_layout);
        }
    }
}
