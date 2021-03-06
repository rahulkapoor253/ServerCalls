package com.skeleton.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.skeleton.fragment.SigninFragment;
import com.skeleton.fragment.SignupFragment;

import java.util.List;

/**
 * Developer: Saurabh Verma
 * Dated: 03-03-2017.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments;
    private String[] mTabHeader = new String[]{"Sign In", "Sign Up"};

    /**
     * Instantiates a new Pager adapter.
     *
     * @param fm        the fm
     * @param fragments the fragments
     */
    public PagerAdapter(final FragmentManager fm, final List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;

    }

    /**
     *
     * @param position pos
     * @return return
     */
    @Override
    public Fragment getItem(final int position) {

        switch (position) {

            case 0:
                return new SigninFragment();
            case 1:
                return new SignupFragment();
            default:
                return new SigninFragment();

        }

    }

    /**
     *
     * @return return
     */
    @Override
    public int getCount() {
        if (fragments == null) {
            return 0;
        } else {
            return fragments.size();
        }
    }

    /**
     *
     * @param position pos
     * @return return
     */
    @Override
    public CharSequence getPageTitle(final int position) {
        return mTabHeader[position];
    }
}
