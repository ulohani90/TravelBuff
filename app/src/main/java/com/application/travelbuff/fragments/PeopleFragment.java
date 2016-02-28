package com.application.travelbuff.fragments;

import android.os.Bundle;

/**
 * Created by Umesh Lohani on 2/15/2016.
 */
public class PeopleFragment extends BaseFragment {

    public static PeopleFragment newInstance(Bundle bundle) {
        PeopleFragment fragment = new PeopleFragment();
        fragment.setArguments(bundle);
        return fragment;

    }
}
