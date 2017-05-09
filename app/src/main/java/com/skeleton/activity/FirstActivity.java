package com.skeleton.activity;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.skeleton.R;
import com.skeleton.fragment.SigninFragment;
import com.skeleton.fragment.SignupFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahulkapoor on 09/05/17.
 */

public class FirstActivity extends BaseActivity {

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        init();


        mPagerAdapter = new com.skeleton.adapter.PagerAdapter(getSupportFragmentManager(), fragments);


    }

    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        fragments = new ArrayList<>();
        fragments.add(new SigninFragment());
        fragments.add(new SignupFragment());


    }


}
