package com.itunes.books;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itunes.books.intf.BookFetchListener;
import com.itunes.books.model.apimodel.Book;
import com.itunes.books.network.NetworkAdapter;

import java.util.List;

public class BookListFragment extends Fragment implements BookFetchListener {

    private static final String TAG = BookListFragment.class.getSimpleName();

    public static BookListFragment createInstance(String title, String bookType, String region) {
        BookListFragment bookListFragment = new BookListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.TITLE, title);
        bundle.putString(Constants.BOOK_TYPE, bookType);
        bundle.putString(Constants.REGION, region);
        bookListFragment.setArguments(bundle);
        return bookListFragment;
    }

    private String getBookType() {
        String category = null;
        category = getArguments().getString(Constants.BOOK_TYPE);
        Log.d(TAG, "Category :" + category);
        return category;
    }

    private String getBookRegion() {
        String region = null;
        region = getArguments().getString(Constants.REGION);
        Log.d(TAG, "Category :" + region);
        return region;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.books_fragment, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "loaded");
        super.onActivityCreated(savedInstanceState);
        showProgress();
        if (getBookRegion() != null && getBookType() != null) {
            NetworkAdapter.getInstance().getBooks(getBookType(), getBookRegion(), this);
        }

    }

    @Override
    public void onBooksFetched(List<Book> books) {
        dismissProgress();
    }

    @Override
    public void onBooksFetchFailed(String message) {
        dismissProgress();
    }

    private void showProgress() {
        if (getView() != null) {
            getView().findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        }
    }

    private void dismissProgress() {
        if (getView() != null) {
            getView().findViewById(R.id.progressBar).setVisibility(View.GONE);
        }
    }
}
