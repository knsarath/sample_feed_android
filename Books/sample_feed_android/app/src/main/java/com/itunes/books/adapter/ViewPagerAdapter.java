package com.itunes.books.adapter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.itunes.books.constants.Constants;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private Fragment[] mFragments;

    public ViewPagerAdapter(FragmentManager fm, Fragment... fragments) {
        super(fm);
        mFragments = fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Bundle arguments = mFragments[position].getArguments();
        String title = arguments.getString(Constants.TITLE, "");
        return title;
    }

    @Override
    public int getCount() {
        return (mFragments == null) ? 0 : mFragments.length;
    }
}
