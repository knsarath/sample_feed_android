package com.itunes.books.model.apimodel;

import com.google.gson.annotations.SerializedName;

public class BookName {
    @SerializedName("label")
    private String mName;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}