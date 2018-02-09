package com.swarawan.greendao.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.swarawan.greendao.R;
import com.swarawan.greendao.database.Book;

/**
 * Created by rioswarawan on 2/9/18.
 */

public class BookViewHolder extends RecyclerView.ViewHolder {

    private View view;

    public BookViewHolder(View itemView) {
        super(itemView);
        view = itemView;
    }

    public void bind(Book book) {
        ((TextView) itemView.findViewById(R.id.textTitle)).setText(book.getTitle());
        ((TextView) itemView.findViewById(R.id.textContent)).setText(book.getContent());
    }
}
