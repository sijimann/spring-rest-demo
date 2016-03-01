package com.books.core.services.util;

import com.books.core.models.Author;
import com.books.core.models.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simba on 2/27/2016.
 */
public class BookList {
    private List<Book> books = new ArrayList<Book>();

    public BookList(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
