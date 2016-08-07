package com.itunes.books;

import android.app.Application;
import android.content.res.Configuration;

import com.itunes.books.network.ApiClient;
import com.itunes.books.network.ApiInterface;

public class BookFeedApplication extends Application {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
