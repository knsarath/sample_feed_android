package com.itunes.books.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.itunes.books.model.Region;

import java.util.ArrayList;
import java.util.List;

public class RegionSpinnerAdapter extends ArrayAdapter<Region> {

    private List<Region> mRegions = new ArrayList<>();

    public RegionSpinnerAdapter(Context context, int resource, List<Region> objects) {
        super(context, resource, objects);
    }

    @Override
    public int getCount() {
        return mRegions.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
