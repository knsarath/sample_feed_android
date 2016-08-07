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

    public BookName getBookName() {
        return mBookName;
    }

    public void setBookName(BookName bookName) {
        mBookName = bookName;
    }

    public List<BookImage> getBookImages() {
        return mBookImages;
    }

    public void setBookImages(List<BookImage> bookImages) {
        mBookImages = bookImages;
    }

    public BookPrice getBookPrice() {
        return mBookPrice;
    }

    public void setBookPrice(BookPrice bookPrice) {
        mBookPrice = bookPrice;
    }

    public Link getLink() {
        return mLink;
    }

    public void setLink(Link link) {
        mLink = link;
    }

    public Author getAuthor() {
        return mAuthor;
    }

    public void setAuthor(Author author) {
        mAuthor = author;
    }

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        mCategory = category;
    }

    public BookRelaseDate getBookRelaseDate() {
        return mBookRelaseDate;
    }

    public void setBookRelaseDate(BookRelaseDate bookRelaseDate) {
        mBookRelaseDate = bookRelaseDate;
    }

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