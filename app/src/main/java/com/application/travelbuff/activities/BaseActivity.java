package com.application.travelbuff.activities;

import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

/**
 * Created by Umesh Lohani on 2/13/2016.
 */
public class BaseActivity extends AppCompatActivity{

    /**
     * Returns display metrics
     *
     * @return
     */
    public DisplayMetrics getDisplayMetrics() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }
}
