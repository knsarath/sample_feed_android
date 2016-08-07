package com.itunes.books.model.apimodel;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class BookRelaseDate {
    @SerializedName("label")
    private Date mDate;

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
