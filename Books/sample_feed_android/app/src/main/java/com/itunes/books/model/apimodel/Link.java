package com.itunes.books.model.apimodel;

import com.google.gson.annotations.SerializedName;

public class Link
{
    @SerializedName("attributes")
    private Href mHref;

    public Href getHref() {
        return mHref;
    }

    public void setHref(Href href) {
        mHref = href;
    }
}