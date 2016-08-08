package com.itunes.books.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegionInfo {
    @SerializedName("regions")
    private List<Region> mRegions;

    public List<Region> getRegions() {
        return mRegions;
    }

    public void setRegions(List<Region> regions) {
        mRegions = regions;
    }
}
