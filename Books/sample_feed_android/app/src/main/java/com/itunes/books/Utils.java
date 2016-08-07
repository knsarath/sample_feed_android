package com.itunes.books;


import android.content.Context;

import com.google.gson.Gson;
import com.itunes.books.model.RegionInfo;

import java.io.IOException;
import java.io.InputStream;

public class Utils {
    public static <T extends Object> T loadJSONFromAsset(Context context, String fileName, Class<T> classOfT) {
        T result = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            Gson gson = new Gson();
            result = gson.fromJson(json, classOfT);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return result;
    }
}
