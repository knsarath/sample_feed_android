package com.itunes.books.model.apimodel;

import com.google.gson.annotations.SerializedName;

public class Href {
    @SerializedName("href")
    private String mUrl;

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
