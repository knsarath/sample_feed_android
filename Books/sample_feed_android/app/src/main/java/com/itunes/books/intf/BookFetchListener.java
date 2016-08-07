package com.itunes.books.intf;


import com.itunes.books.model.apimodel.Book;

import java.util.List;

public interface BookFetchListener {
    void onBooksFetched(List<Book> books);

    void onBooksFetchFailed(String message);
}
