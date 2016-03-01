package com.books.core.services;

import com.books.core.models.Book;
import com.books.core.services.util.AuthorList;
import com.books.core.services.util.BookList;

import java.util.List;

/**
 * Created by Simba on 2/27/2016.
 */
public interface BookService {

    public BookList findAllBooks();
    public Book findBook(Long id);
    public Book findBookByTitle(String name);
    public Book createBook(Long id,Book data);
    public BookList finBooksByAuthor(Long id);
    public Book deleteBook(Long id);
    public Book updateBook( Book data);
}
