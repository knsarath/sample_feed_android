package com.itunes.books.network;

import android.util.Log;

import com.itunes.books.intf.BookFetchListener;
import com.itunes.books.model.apimodel.BooksFeed;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkAdapter {

    private static final String TAG = NetworkAdapter.class.getSimpleName();
    private static NetworkAdapter instance = null;
    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

    private NetworkAdapter() {
        // Exists only to defeat instantiation.
    }

    public static NetworkAdapter getInstance() {
        if (instance == null) {
            instance = new NetworkAdapter();
        }
        return instance;
    }

    public void getBooks(String bookType, String bookRegion, final BookFetchListener callback) {
        Call<BooksFeed> call = apiService.getBooks(bookRegion, bookType);
        call.enqueue(new Callback<BooksFeed>() {
            @Override
            public void onResponse(Call<BooksFeed> call, Response<BooksFeed> response) {
                if (response != null && response.body() != null && response.body().getFeed() != null && response.body().getFeed().getBooks() != null) {
                    Log.d(TAG, response.body().toString());
                    callback.onBooksFetched(response.body().getFeed().getBooks());
                } else {
                    callback.onBooksFetchFailed("");
                }
            }

            @Override
            public void onFailure(Call<BooksFeed> call, Throwable t) {
                Log.e(TAG, t.toString());
                callback.onBooksFetchFailed(t.getMessage());
            }
        });
    }
}