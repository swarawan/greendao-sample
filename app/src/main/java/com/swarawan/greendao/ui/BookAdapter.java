package com.swarawan.greendao.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swarawan.greendao.R;
import com.swarawan.greendao.database.Book;

import java.util.List;

/**
 * Created by rioswarawan on 2/9/18.
 */

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {

    private List<Book> books;

    public BookAdapter(List<Book> books) {
        this.books = books;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        holder.bind(books.get(position));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void updateList(List<Book> newList) {
        books.addAll(newList);
        notifyDataSetChanged();
    }

    public void addList(List<Book> newList) {
        books.clear();
        books.addAll(newList);
        notifyDataSetChanged();
    }

}
