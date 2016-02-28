package com.application.travelbuff.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.application.travelbuff.R;
import com.application.travelbuff.utils.CommonLib;

/**
 * Created by Umesh Lohani on 2/15/2016.
 */
public class FeedListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    int TYPE_FEED = 0;
    int TYPE_LOADER = 1;

    int feedImageHeight;

    public FeedListRecyclerViewAdapter(Context context, int feedImageHeight) {
        this.context = context;
        this.feedImageHeight = feedImageHeight;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        if (viewType == TYPE_FEED) {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.feed_item_layout, parent, false);
            holder = new FeedViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.progress_footer_layout, parent, false);
            holder = new LoadingViewHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_FEED) {
            FeedViewHolder feedHolder = (FeedViewHolder) holder;
            feedHolder.userImg.setImageBitmap(CommonLib.getBitmap(context, R.drawable.user_dummy_img, context.getResources().getDimensionPixelSize(R.dimen.user_image_height), context.getResources().getDimensionPixelSize(R.dimen.user_image_height)));
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, feedImageHeight);
            feedHolder.feedImg.setLayoutParams(lp);
            feedHolder.feedImg.setImageBitmap(CommonLib.getBitmap(context, R.drawable.dummy_img, feedImageHeight, feedImageHeight));
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return 10 + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return TYPE_LOADER;
        } else {
            return TYPE_FEED;
        }
    }

    public class FeedViewHolder extends RecyclerView.ViewHolder {
        ImageView userImg, feedImg;
        TextView userName, feedTime, feedTitle, feedDesc;
        LinearLayout likeLayout, shareLayout, creditLayout;

        public FeedViewHolder(View itemView) {
            super(itemView);
            userImg = (ImageView) itemView.findViewById(R.id.user_img);
            feedImg = (ImageView) itemView.findViewById(R.id.feed_img);
            userName = (TextView) itemView.findViewById(R.id.user_name);
            feedTime = (TextView) itemView.findViewById(R.id.feed_time);
            feedTitle = (TextView) itemView.findViewById(R.id.feed_title);
            feedDesc = (TextView) itemView.findViewById(R.id.feed_description);
            likeLayout = (LinearLayout) itemView.findViewById(R.id.like_layout);
            shareLayout = (LinearLayout) itemView.findViewById(R.id.share_layout);
            creditLayout = (LinearLayout) itemView.findViewById(R.id.credit_layout);

        }
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder {

        public LoadingViewHolder(View view) {
            super(view);

        }

    }
}
