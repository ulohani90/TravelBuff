package com.application.travelbuff.decorators;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Umesh Lohani on 2/16/2016.
 */
public class GridItemDecorator extends RecyclerView.ItemDecoration{

    int space;
    public GridItemDecorator(int space){
        this.space = space;
    }
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.top = space;
        if(parent.getChildAdapterPosition(view) %2==0){
            outRect.left=space;
            outRect.right=space/2;
        }else{
            outRect.left=space/2;
            outRect.right=space;
        }
    }

    }