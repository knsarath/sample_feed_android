package com.itunes.books.model.apimodel;

import com.google.gson.annotations.SerializedName;

public class BookType {
    @SerializedName("type")
    private String mType;
    @SerializedName("path")
    private String mUrlPath;

    public String getTypeTitle() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getUrlPath() {
        return mUrlPath;
    }

    public void setUrlPath(String urlPath) {
        mUrlPath = urlPath;
    }
}
