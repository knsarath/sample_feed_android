package com.itunes.books.config;

import android.content.Context;

import com.itunes.books.MainActivity;
import com.itunes.books.Region;
import com.itunes.books.Utils;
import com.itunes.books.model.BookTypeInfo;
import com.itunes.books.model.RegionInfo;
import com.itunes.books.model.apimodel.BookType;

import java.util.ArrayList;
import java.util.List;

public class BooksFeedConfiguration {
    public static final String REGION_CONFIGURATION_FILE = "region_config.json";
    public static final String BOOK_TYPES_CONFIGFILE = "book_types.json";

    public static List<BookType> getAvailableBookTypes(Context context) {
        List<BookType> bookTypes = null;
        BookTypeInfo bookTypeInfo = Utils.loadJSONFromAsset(context, BOOK_TYPES_CONFIGFILE, BookTypeInfo.class);
        if (bookTypeInfo != null) {
            bookTypes = bookTypeInfo.getBookTypes();
        }
        return bookTypes;
    }

    public static List<Region> getAvailableRegions(Context context) {
        final RegionInfo regionInfo = Utils.loadJSONFromAsset(context, REGION_CONFIGURATION_FILE, RegionInfo.class);
        final ArrayList<Region> list = new ArrayList<>();
        return list;
    }
}
