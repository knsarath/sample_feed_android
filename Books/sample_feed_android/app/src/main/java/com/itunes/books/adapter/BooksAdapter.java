package com.itunes.books.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itunes.books.R;
import com.itunes.books.model.apimodel.Book;
import com.itunes.books.model.apimodel.BookImage;
import com.itunes.books.model.apimodel.BookPriceInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {
    private static final int LARGE_IMAGE = 2;
    private List<Book> mBooks = new ArrayList<>();

    public BooksAdapter(ArrayList<Book> books) {
        mBooks = books;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = mBooks.get(position);
        holder.mName.setText(book.getBookName().getName());
        holder.mAuthor.setText(book.getAuthor().getName());
        holder.mCategory.setText(book.getCategory().getCategoryInfo().getName());
        holder.mReleasedOn.setText(book.getBookRelaseDate().getDate().toString());
        BookPriceInfo bookPriceInfo = book.getBookPrice().getBookPriceInfo();
        final String amountText = bookPriceInfo.getAmount() + " " + bookPriceInfo.getCurrency();
        holder.mPrice.setText(amountText);

        List<BookImage> bookImages = book.getBookImages();
        if (bookImages != null && bookImages.size() > 1) {
            String bookImageUrl = bookImages.get(LARGE_IMAGE).getBookImageUrl();
            Picasso.with(holder.itemView.getContext()).load(bookImageUrl).into(holder.mLogo);
        }
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public void setItems(List<Book> books) {
        mBooks = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        TextView mAuthor;
        TextView mCategory;
        TextView mReleasedOn;
        TextView mPrice;
        ImageView mLogo;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.title);
            mAuthor = (TextView) itemView.findViewById(R.id.author);
            mCategory = (TextView) itemView.findViewById(R.id.category);
            mReleasedOn = (TextView) itemView.findViewById(R.id.relased_on);
            mPrice = (TextView) itemView.findViewById(R.id.price);
            mLogo = (ImageView) itemView.findViewById(R.id.logo);
        }
    }
}
