package com.application.travelbuff.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.application.travelbuff.fragments.BaseFragment;
import com.application.travelbuff.fragments.ExploreFragment;
import com.application.travelbuff.fragments.FeedFragment;

/**
 * Created by Umesh Lohani on 2/15/2016.
 * Adapter for the ViewPager used in HomeActivity.class
 */
public class HomeViewPagerAdapter extends FragmentStatePagerAdapter {

    public HomeViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = null;
        switch (position) {
            case 0:
                fragment = FeedFragment.newInstance(null);
                break;
            case 1:
                fragment = ExploreFragment.newInstance(null);
                break;
            /*case 2:
                fragment = InterestsFragment.newInstance(null);
                break;
            case 3:
                fragment = PeopleFragment.newInstance(null);
                break;*/

        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
