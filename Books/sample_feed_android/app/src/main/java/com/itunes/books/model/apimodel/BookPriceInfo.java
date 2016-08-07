package com.itunes.books.model.apimodel;


import com.google.gson.annotations.SerializedName;

public class BookPriceInfo {
    @SerializedName("amount")
    private String mAmount;
    @SerializedName("currency")
    private String mCurrency;

    public String getAmount() {
        return mAmount;
    }

    public void setAmount(String amount) {
        mAmount = amount;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }
}