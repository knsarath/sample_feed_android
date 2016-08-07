package com.itunes.books;

import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.itunes.books.config.BooksFeedConfiguration;
import com.itunes.books.model.apimodel.BookType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
    }

    private void loadViewPagerPages(String regionCode) {
        List<BookType> bookTypes = BooksFeedConfiguration.getAvailableBookTypes(this);
        if (bookTypes != null) {
            int numberOfBooktypes = bookTypes.size();
            BookListFragment[] bookListFragments = new BookListFragment[numberOfBooktypes];
            for (int i = 0; i < numberOfBooktypes; i++) {
                BookType bookType = bookTypes.get(i);
                BookListFragment bookListFragment = BookListFragment.createInstance(bookType.getTypeTitle(), bookType.getUrlPath(), regionCode);
                bookListFragments[i] = bookListFragment;
            }
            mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), bookListFragments);
            mViewPager.setAdapter(mViewPagerAdapter);
            mTabLayout.setupWithViewPager(mViewPager);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        final List<Region> regionList = BooksFeedConfiguration.getAvailableRegions(this);

        ArrayList<String> regionCodeList = new ArrayList<>();
        for (Region region : regionList) {
            regionCodeList.add(region.getRegionCode());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, regionCodeList);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String regionCode = regionList.get(position).getRegionCode();
                loadViewPagerPages(regionCode);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }); //
        return true;
    }
}
