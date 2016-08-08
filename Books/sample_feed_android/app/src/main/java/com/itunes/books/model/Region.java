package com.itunes.books.model;

import com.google.gson.annotations.SerializedName;

public class Region {
    @SerializedName("region")
    private String mRegionTitle;
    @SerializedName("key")
    private String mRegionCode;

    public String getRegionTitle() {
        return mRegionTitle;
    }

    public void setRegionTitle(String regionTitle) {
        mRegionTitle = regionTitle;
    }

    public String getRegionCode() {
        return mRegionCode;
    }

    public void setRegionCode(String regionCode) {
        mRegionCode = regionCode;
    }

    @Override
    public String toString() {
        return mRegionTitle;
    }
}
