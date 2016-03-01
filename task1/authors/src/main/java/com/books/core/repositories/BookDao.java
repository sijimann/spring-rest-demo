package com.books.core.repositories;

import com.books.core.models.Author;
import com.books.core.models.Book;

import java.util.List;

/**
 * Created by Simba on 2/26/2016.
 */
public interface BookDao {

    public List<Book> findAllBooks();
    public Book findBook(Long id);
    public Book findBookByTitle(String name);
    public Book createBook(Book data);
    public List<Book> findBooksByAuthor(Long id);
    public Book deleteBook(Long id);
    public Book updateBook( Book data);
}
