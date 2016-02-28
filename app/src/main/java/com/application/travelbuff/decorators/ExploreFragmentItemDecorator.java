package com.application.travelbuff.decorators;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Umesh Lohani on 2/23/2016.
 */
public class ExploreFragmentItemDecorator extends RecyclerView.ItemDecoration {

    int space;

    public ExploreFragmentItemDecorator(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.top = space;
        if (parent.getChildAdapterPosition(view) == 0 || parent.getChildAdapterPosition(view) == 5 || parent.getChildAdapterPosition(view) == 10) {
            outRect.left = space;
            outRect.right = space;
        } else {
            if (parent.getChildAdapterPosition(view) == 1 || parent.getChildAdapterPosition(view) == 3 || parent.getChildAdapterPosition(view) == 6 || parent.getChildAdapterPosition(view) == 8 || parent.getChildAdapterPosition(view) == 11 || parent.getChildAdapterPosition(view) == 13) {
                outRect.left = space;
                outRect.right = space / 2;
            } else {
                outRect.right = space;
                outRect.left = space / 2;

            }
            if (parent.getChildAdapterPosition(view) == 13 || parent.getChildAdapterPosition(view) == 14) {
                outRect.bottom = space;
            }
        }
    }

}
