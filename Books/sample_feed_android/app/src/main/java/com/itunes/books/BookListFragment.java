package com.itunes.books;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itunes.books.adapter.BooksAdapter;
import com.itunes.books.constants.Constants;
import com.itunes.books.intf.BookFetchListener;
import com.itunes.books.intf.RegionChangeListener;
import com.itunes.books.model.apimodel.Book;
import com.itunes.books.network.NetworkAdapter;

import java.util.ArrayList;
import java.util.List;

public class BookListFragment extends Fragment implements BookFetchListener, RegionChangeListener {

    private static final String TAG = BookListFragment.class.getSimpleName();
    private BooksAdapter mBooksAdapter;

    public static BookListFragment createInstance(String title, String bookType) {
        BookListFragment bookListFragment = new BookListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.TITLE, title);
        bundle.putString(Constants.BOOK_TYPE, bookType);
        bookListFragment.setArguments(bundle);
        return bookListFragment;
    }

    private String getBookType() {
        String category = null;
        category = getArguments().getString(Constants.BOOK_TYPE);
        Log.d(TAG, "Category :" + category);
        return category;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.books_fragment, null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        mBooksAdapter = new BooksAdapter(new ArrayList<Book>());
        recyclerView.setAdapter(mBooksAdapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            MainActivity activity = (MainActivity) context;
            activity.addRegionChangeListeners(this);
        }
    }

    @Override
    public void onRegionChanged(String regionCode) {
        loadBooks(regionCode);
    }

    private void loadBooks(String regionCode) {
        Log.d(TAG, "loaded");
        showProgress();
        if (regionCode != null && getBookType() != null) {
            NetworkAdapter.getInstance().getBooks(getBookType(), regionCode, this);
        } else {
            dismissProgress();
        }
    }

    @Override
    public void onBooksFetched(List<Book> books) {
        dismissProgress();
        if (mBooksAdapter != null && books != null) {
            mBooksAdapter.setItems(books);
        }
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
