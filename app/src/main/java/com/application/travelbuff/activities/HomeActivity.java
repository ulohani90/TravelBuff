package com.application.travelbuff.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.application.travelbuff.R;
import com.application.travelbuff.adapters.HomeViewPagerAdapter;
import com.application.travelbuff.widgets.CustomTabLayout;


/**
 * Created by Umesh Lohani on 2/14/2016.
 */
public class HomeActivity extends BaseActivity {


    Toolbar toolbar;

    DrawerLayout mDrawer;

    ActionBarDrawerToggle mToggle;

    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        addToolbarView(toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // getSupportActionBar().setIcon(R.drawable.ic_app_title_logo);
        setUpDrawer();
        mToggle.syncState();
        setUpTabs();

    }


    /**
     * Add data to the Tabs
     */
    public void setUpTabs() {
        CustomTabLayout tabLayout = (CustomTabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Feed"));
        tabLayout.addTab(tabLayout.newTab().setText("Explore"));
       // tabLayout.addTab(tabLayout.newTab().setText("Interests"));
        //tabLayout.addTab(tabLayout.newTab().setText("People"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        setUpViewPager(tabLayout);
    }

    /**
     * Add Contents to the viewpager
     *
     * @param tabLayout Tablayout object to add a page change listener
     */
    public void setUpViewPager(CustomTabLayout tabLayout) {
        final ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    public void addToolbarView(Toolbar toolbar) {
        View view = LayoutInflater.from(this).inflate(R.layout.toolbar_text_layout, toolbar, false);
        ((TextView) view.findViewById(R.id.textview)).setText("TravelBuff");
        toolbar.addView(view);
    }

    private void setUpDrawer() {
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        // Adding action bar drawer toggle
        mToggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.app_name,
                R.string.app_name);
        mDrawer.setDrawerListener(mToggle);
        mDrawer.setDrawerListener(new DrawerLayout.DrawerListener() {

            @Override
            public void onDrawerStateChanged(int arg0) {
            }

            @Override
            public void onDrawerSlide(View arg0, float arg1) {
                //  scaleFAB(arg1);
            }

            @Override
            public void onDrawerOpened(View arg0) {
            }

            @Override
            public void onDrawerClosed(View arg0) {

            }
        });

        navView = (NavigationView) findViewById(R.id.navigation_view);

        /*CircularImageView userImage = (CircularImageView) navView.findViewById(R.id.user_img);
        userImage.setOnClickListener(this);
        TextView userName = (TextView) navView.findViewById(R.id.drawer_user_name);

        ImageView backgroundImg = (ImageView) navView.findViewById(R.id.drawer_user_info_background_image_blurr);
        if (AppPreferences.isUserLogIn(this)) {
            if (!AppPreferences.getUserPhoto(this).equalsIgnoreCase("")) {
                userImage.setImageBitmap(CommonLib.getBitmap(this, R.drawable.ic_user, getResources().getDimensionPixelSize(R.dimen.abc_action_bar_default_height_material), getResources().getDimensionPixelSize(R.dimen.abc_action_bar_default_height_material)));

                loadImage(AppPreferences.getUserPhoto(this), userImage,
                        getResources().getDimensionPixelSize(R.dimen.pro_image_size),
                        getResources().getDimensionPixelSize(R.dimen.pro_image_size), false, false);
                loadImage(AppPreferences.getUserPhoto(this), backgroundImg, width, width, false, true);
            } else {
                userImage.setImageBitmap(CommonLib.getBitmap(this, R.drawable.ic_user, getResources().getDimensionPixelSize(R.dimen.abc_action_bar_default_height_material), getResources().getDimensionPixelSize(R.dimen.abc_action_bar_default_height_material)));
                backgroundImg.setImageBitmap(CommonLib.getBitmap(this, R.drawable.ic_user_profile_bg, width, width));
            }
            ((TextView) navView.findViewById(R.id.drawer_user_email)).setVisibility(View.VISIBLE);
            ((TextView) navView.findViewById(R.id.drawer_user_email)).setText(AppPreferences.getUserEmail(this));
            ((TextView) navView.findViewById(R.id.drawer_user_phone)).setVisibility(View.VISIBLE);
            ((TextView) navView.findViewById(R.id.drawer_user_phone)).setText(AppPreferences.getUserPhoneNumber(this));

            userName.setText(AppPreferences.getUserName(this));
        } else {
            SpannableString spannablecontent = new SpannableString("Hello! Login/Signup ?");
            userImage.setImageBitmap(CommonLib.getBitmap(this, R.drawable.ic_user, getResources().getDimensionPixelSize(R.dimen.abc_action_bar_default_height_material), getResources().getDimensionPixelSize(R.dimen.abc_action_bar_default_height_material)));
            spannablecontent.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 15, spannablecontent.length(), 0);
            userName.setText(spannablecontent);
            backgroundImg.setImageBitmap(CommonLib.getBitmap(this, R.drawable.ic_user_profile_bg, width, width));
            findViewById(R.id.drawer_user_container).setOnClickListener(this);
        }
*/
    }

    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mToggle.onConfigurationChanged(newConfig);
    }

}
