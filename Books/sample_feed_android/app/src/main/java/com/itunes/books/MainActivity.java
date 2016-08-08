package com.itunes.books;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.itunes.books.adapter.ViewPagerAdapter;
import com.itunes.books.config.BooksFeedConfiguration;
import com.itunes.books.intf.RegionChangeListener;
import com.itunes.books.model.Region;
import com.itunes.books.model.apimodel.BookType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private TabLayout mTabLayout;
    private ArrayList<RegionChangeListener> mRegionChangeListeners = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        loadViewPagerPages();
    }

    private void loadViewPagerPages() {
        List<BookType> bookTypes = BooksFeedConfiguration.getAvailableBookTypes(this);
        if (bookTypes != null) {
            int numberOfBooktypes = bookTypes.size();
            BookListFragment[] bookListFragments = new BookListFragment[numberOfBooktypes];
            for (int i = 0; i < numberOfBooktypes; i++) {
                BookType bookType = bookTypes.get(i);
                BookListFragment bookListFragment = BookListFragment.createInstance(bookType.getTypeTitle(), bookType.getUrlPath());
                bookListFragments[i] = bookListFragment;
            }
            mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), bookListFragments);
            mViewPager.setOffscreenPageLimit(3);
            mViewPager.setAdapter(mViewPagerAdapter);
            mTabLayout.setupWithViewPager(mViewPager);
        }
    }

    public void addRegionChangeListeners(RegionChangeListener regionChangeListener) {
        if (regionChangeListener != null)
            mRegionChangeListeners.add(regionChangeListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        final List<Region> regionList = BooksFeedConfiguration.getAvailableRegions(this);

        ArrayList<String> regionCodeList = new ArrayList<>();
        for (Region region : regionList) {
            regionCodeList.add(region.getRegionTitle());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, regionCodeList);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String regionCode = regionList.get(position).getRegionCode();
                Log.d(TAG, "Region Code : " + regionCode);
                if (mRegionChangeListeners != null) {
                    for (RegionChangeListener regionChangeListener : mRegionChangeListeners) {
                        regionChangeListener.onRegionChanged(regionCode);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }); //
        return true;
    }
}
