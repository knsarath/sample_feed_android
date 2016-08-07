package com.itunes.books.model;


import com.google.gson.annotations.SerializedName;
import com.itunes.books.model.apimodel.BookType;

import java.util.List;

public class BookTypeInfo {
    @SerializedName("booktypes")
    private List<BookType> mBookTypes;

    public List<BookType> getBookTypes() {
        return mBookTypes;
    }

    public void setBookTypes(List<BookType> bookTypes) {
        mBookTypes = bookTypes;
    }
}
