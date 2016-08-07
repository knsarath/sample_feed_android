package com.itunes.books.model.apimodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Feed
{
    @SerializedName("entry")
    private List<Book> mBooks;

    public List<Book> getBooks() {
        return mBooks;
    }

    public void setBooks(List<Book> books) {
        mBooks = books;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "mBooks=" + mBooks +
                '}';
    }
}
