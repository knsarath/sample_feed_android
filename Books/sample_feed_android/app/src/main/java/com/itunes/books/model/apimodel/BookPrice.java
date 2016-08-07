package com.itunes.books.model.apimodel;

import com.google.gson.annotations.SerializedName;

public class BookPrice {
    @SerializedName("attributes")
    private BookPriceInfo mBookPriceInfo;

    public BookPriceInfo getBookPriceInfo() {
        return mBookPriceInfo;
    }

    public void setBookPriceInfo(BookPriceInfo bookPriceInfo) {
        mBookPriceInfo = bookPriceInfo;
    }
}