package com.application.travelbuff.fragments;

import android.os.Bundle;

/**
 * Created by Umesh Lohani on 2/15/2016.
 */
public class InterestsFragment extends BaseFragment {

    public static InterestsFragment newInstance(Bundle bundle) {
        InterestsFragment fragment = new InterestsFragment();
        fragment.setArguments(bundle);
        return fragment;

    }
}
