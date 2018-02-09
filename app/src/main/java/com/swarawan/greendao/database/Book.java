package com.swarawan.greendao.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by rioswarawan on 2/9/18.
 */

@Entity
public class Book {

    @Id
    private Long id;
    private String title;
    private String content;
    
    @Generated(hash = 1521602329)
    public Book(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Generated(hash = 1839243756)
    public Book() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
