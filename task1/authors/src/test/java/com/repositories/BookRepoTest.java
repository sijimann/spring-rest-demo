package com.repositories;

import com.books.WebConfig;
import com.books.core.models.Author;
import com.books.core.models.Book;
import com.books.core.services.AuthorService;
import com.books.core.services.BookService;
import com.books.core.services.util.AuthorList;
import com.books.core.services.util.BookList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Simba on 2/27/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=WebConfig.class)
@WebAppConfiguration
public class BookRepoTest {

    @Autowired
    private BookService service;

    private Book book;

    @Before
    @Transactional
    @Rollback(false)
    public void setup()
    {
        book = new Book();
        book.setTitle("mybook");
        book.setSynopsis("just a book");
        book.setPublishDate(new Date(System.currentTimeMillis()));
        service.createBook(2L,book);

    }

    @Test
    @Transactional
    public void testFind()
    {
        Book b = service.findBook(this.book.getId());
        assertNotNull(b);
        assertEquals(b.getTitle(), "mybook");
        assertEquals(b.getSynopsis(), "just a book");
    }


    @Test
    @Transactional
    public void testFindAll(){
        BookList bookList=service.findAllBooks();
        assertNotNull(bookList.getBooks());
        assertEquals(bookList.getBooks().get(0).getTitle(), "mybook");
        assertEquals(bookList.getBooks().get(0).getSynopsis(), "just a book");
    }

    @Test
    @Transactional
    public void testFindByName(){
        Book b=service.findBookByTitle("mybook");
        assertNotNull(b);
        assertEquals(b.getTitle(), "mybook");
    }

}
