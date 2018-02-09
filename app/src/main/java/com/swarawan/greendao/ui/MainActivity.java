package com.swarawan.greendao.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.swarawan.greendao.App;
import com.swarawan.greendao.R;
import com.swarawan.greendao.database.Book;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayoutManager linearLayoutManager;
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutManager = new LinearLayoutManager(this);
        bookAdapter = new BookAdapter(new ArrayList<Book>());

        findViewById(R.id.buttonSave).setOnClickListener(onSaveClicked);
        ((RecyclerView) findViewById(R.id.rvBooks)).setLayoutManager(linearLayoutManager);
        ((RecyclerView) findViewById(R.id.rvBooks)).setAdapter(bookAdapter);

        loadAllBooks();
    }

    private View.OnClickListener onSaveClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            prepareSave();
        }
    };

    private void prepareSave() {
        String title = ((EditText) findViewById(R.id.inputTitle)).getText().toString();
        String content = ((EditText) findViewById(R.id.inputContent)).getText().toString();

        if (title.equals("") || content.equals("")) {
            Toast.makeText(this, "Form cannot empty", Toast.LENGTH_SHORT).show();
        } else {
            save(title, content);
        }
    }

    private void save(String title, String content) {
        Book book = new Book();
        book.setTitle(title);
        book.setContent(content);

        ((App) getApplication()).getDaoSession().getBookDao().insertOrReplace(book);

        loadAllBooks();
    }

    private void loadAllBooks() {
        List<Book> books = ((App) getApplication()).getDaoSession().getBookDao().loadAll();
        bookAdapter.updateList(books);
    }
}
