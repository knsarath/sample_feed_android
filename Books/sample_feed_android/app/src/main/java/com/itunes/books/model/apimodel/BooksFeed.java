package com.itunes.books.model.apimodel;

import com.google.gson.annotations.SerializedName;

public class BooksFeed {
    @SerializedName("feed")
    private Feed mFeed;

    public Feed getFeed() {
        return mFeed;
    }

    public void setFeed(Feed feed) {
        mFeed = feed;
    }

    @Override
    public String toString() {
        return "BooksFeed{" +
                "mFeed=" + mFeed +
                '}';
    }
}
