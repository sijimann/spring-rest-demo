package com.books.core.services.impl;

import com.books.core.models.Author;
import com.books.core.models.Book;
import com.books.core.repositories.AuthorDao;
import com.books.core.repositories.BookDao;
import com.books.core.services.BookService;
import com.books.core.services.util.AuthorList;
import com.books.core.services.util.BookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Simba on 2/27/2016.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

    @Override
    public BookList findAllBooks() {
        return new BookList(bookDao.findAllBooks());
    }

    @Override
    public Book findBook(Long id) {
        return bookDao.findBook(id);
    }

    @Override
    public Book findBookByTitle(String name) {
       return bookDao.findBookByTitle(name);
    }

    @Override
    public Book createBook(Long id,Book data) {

        Author author = authorDao.findAuthor(id);
        Book book = bookDao.createBook(data);
        if(author != null)
        {
            book.setAuthor(author);
        }

        return book;


    }

    @Override
    public BookList finBooksByAuthor(Long id) {
        return new BookList(bookDao.findBooksByAuthor(id));
    }

    @Override
    public Book deleteBook(Long id) {
        return bookDao.deleteBook(id);
    }

    @Override
    public Book updateBook(Book data) {
        return bookDao.updateBook(data);
    }
}
