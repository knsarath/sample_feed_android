package com.itunes.books.model.apimodel;

import com.google.gson.annotations.SerializedName;

public class BookImage {
    @SerializedName("label")
    public String mBookImageUrl;

    public String getBookImageUrl() {
        return mBookImageUrl;
    }

    public void setBookImageUrl(String bookImageUrl) {
        mBookImageUrl = bookImageUrl;
    }
}
