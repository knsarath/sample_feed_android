package com.itunes.books.network;

import com.itunes.books.model.apimodel.BooksFeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiInterface {
    @GET("{region}/rss/{category}/limit=25/json")
    Call<BooksFeed> getBooks(@Path("region") String region, @Path("category") String category);

}