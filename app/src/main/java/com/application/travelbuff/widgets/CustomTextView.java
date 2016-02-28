package com.application.travelbuff.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.application.travelbuff.utils.CommonLib;


public class CustomTextView extends TextView {

	public CustomTextView(Context context) {
		super(context);
		setTypeface(CommonLib.getTypeface(context, CommonLib.REGULAR_FONT));
	}

	public CustomTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setTypeface(CommonLib.getTypeface(context, CommonLib.REGULAR_FONT));
	}

	public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		setTypeface(CommonLib.getTypeface(context, CommonLib.REGULAR_FONT));
	}

}
