package com.itunes.books.model.apimodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Book {
    @SerializedName("im:name")
    private BookName mBookName;
    @SerializedName("im:image")
    private List<BookImage> mBookImages;
    @SerializedName("im:price")
    private BookPrice mBookPrice;
    @SerializedName("link")
    private Link mLink;
    @SerializedName("im:artist")
    private Author mAuthor;
    @SerializedName("category")
    private Category mCategory;
    @SerializedName("im:releaseDate")
    private BookRelaseDate mBookRelaseDate;

    @Override
    public String toString() {
        return "Book{" +
                "mBookName=" + mBookName +
                ", mBookImages=" + mBookImages +
                ", mBookPrice=" + mBookPrice +
                ", mLink=" + mLink +
                ", mAuthor=" + mAuthor +
                ", mCategory=" + mCategory +
                ", mBookRelaseDate=" + mBookRelaseDate +
                '}';
    }
}