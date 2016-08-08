package com.itunes.books;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.itunes.books.adapter.ViewPagerAdapter;
import com.itunes.books.config.BooksFeedConfiguration;
import com.itunes.books.intf.RegionChangeListener;
import com.itunes.books.intf.RegionChanger;
import com.itunes.books.model.Region;
import com.itunes.books.model.apimodel.BookType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RegionChanger {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int VIEWPAGER_OFF_SCREEN_LIMIT = 2;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setOffscreenPageLimit(VIEWPAGER_OFF_SCREEN_LIMIT);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        loadViewPagerPages();
    }

    private void loadViewPagerPages() {
        List<BookType> bookTypes = BooksFeedConfiguration.getAvailableBookTypes(this);
        if (bookTypes != null) {
            int numberOfBookTypes = bookTypes.size();
            BookListFragment[] bookListFragments = new BookListFragment[numberOfBookTypes];
            for (int i = 0; i < numberOfBookTypes; i++) {
                BookType bookType = bookTypes.get(i);
                BookListFragment bookListFragment = BookListFragment.createInstance(bookType.getTypeTitle(), bookType.getUrlPath());
                bookListFragments[i] = bookListFragment;
            }
            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), bookListFragments);
            mViewPager.setAdapter(viewPagerAdapter);
            mTabLayout.setupWithViewPager(mViewPager);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        final List<Region> regionList = BooksFeedConfiguration.getAvailableRegions(this);
        ArrayAdapter<Region> adapter = new ArrayAdapter<>(this, R.layout.simple_spinner_item, regionList);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final Region selectedRegion = (Region) parent.getAdapter().getItem(position);
        for (RegionChangeListener regionChangeListener : REGION_CHANGE_LISTENERS) {
            regionChangeListener.onRegionChanged(selectedRegion.getRegionCode());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void addOnRegionChangeListener(RegionChangeListener regionChangeListener) {
        if (regionChangeListener != null) {
            REGION_CHANGE_LISTENERS.add(regionChangeListener);
        }

    }
}
