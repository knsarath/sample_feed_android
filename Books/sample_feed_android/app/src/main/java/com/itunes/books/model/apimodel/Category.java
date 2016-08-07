package com.itunes.books.model.apimodel;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("attributes")
    private CategoryInfo mCategoryInfo;

    public CategoryInfo getCategoryInfo() {
        return mCategoryInfo;
    }

    public void setCategoryInfo(CategoryInfo categoryInfo) {
        mCategoryInfo = categoryInfo;
    }
}
