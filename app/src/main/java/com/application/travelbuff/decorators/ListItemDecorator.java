package com.application.travelbuff.decorators;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Umesh Lohani on 2/15/2016.
 */
public class ListItemDecorator extends RecyclerView.ItemDecoration{

    int space;
    public ListItemDecorator(int space){
        this.space = space;
    }
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        if(parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount()-1){
            outRect.bottom = space;
        }
        outRect.top = space;
        outRect.left=space;
        outRect.right=space;

    }
}
