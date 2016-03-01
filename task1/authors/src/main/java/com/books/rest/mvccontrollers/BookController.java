package com.books.rest.mvccontrollers;

import com.books.core.models.Book;
import com.books.core.services.BookService;
import com.books.core.services.util.BookList;
import com.books.rest.resources.BookListResource;
import com.books.rest.resources.BookResource;
import com.books.rest.resources.asm.BookListResourceAsm;
import com.books.rest.resources.asm.BookResourceAsm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Simba on 2/27/2016.
 */
@RestController
@RequestMapping("/rest/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/{authorId}/author-books",
            method = RequestMethod.POST)
    public ResponseEntity<BookResource> createBookWithAuthor(
            @PathVariable Long authorId,
            @RequestBody BookResource sentBookResource
    ) {
        Book createdBook = null;
        createdBook = bookService.createBook(authorId, sentBookResource.toBook());
        BookResource createdBookResource = new BookResourceAsm().toResource(createdBook);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(createdBookResource.getLink("self").getHref()));
        return new ResponseEntity<BookResource>(createdBookResource, headers, HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<BookListResource> findAllBooks
            (@RequestParam(value = "name",
                    required = false) String name) {
        BookList list = null;
        if (name == null) {
            list = bookService.findAllBooks();
        } else {
            Book book = bookService.findBookByTitle(name);
            list = new BookList(new ArrayList<Book>());
            if (book != null) {
                list = new BookList(Arrays.asList(book));
            }

        }
        BookListResource res = new BookListResourceAsm().toResource(list);
        return new ResponseEntity<BookListResource>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/{authorId}/author-books", method = RequestMethod.GET)
    public ResponseEntity<BookListResource> findAllBooksByAuthor
            (@PathVariable Long authorId) {
        BookList list = bookService.finBooksByAuthor(authorId);
        BookListResource res = new BookListResourceAsm().toResource(list);
        return new ResponseEntity<BookListResource>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/{bookId}",
            method = RequestMethod.GET)
    public ResponseEntity<BookResource> findBook
            (@PathVariable Long bookId) {
        Book book = bookService.findBook(bookId);
        if (book == null) {
            return new ResponseEntity<BookResource>(HttpStatus.NOT_FOUND);
        } else {
            BookResource res = new BookResourceAsm().toResource(book);
            return new ResponseEntity<BookResource>(res, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{bookId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<BookResource> deleteBook
            (@PathVariable Long bookId) {
        Book book = bookService.deleteBook(bookId);
        if (book == null) {
            return new ResponseEntity<BookResource>(HttpStatus.NOT_FOUND);
        } else {
            BookResource res = new BookResourceAsm().toResource(book);
            return new ResponseEntity<BookResource>(res, HttpStatus.OK);
        }
    }

        @RequestMapping(value="/{bookId}",
            method = RequestMethod.PUT)
    public ResponseEntity<BookResource> updateBook(
            @PathVariable Long bookId, @RequestBody BookResource sentBookResource) {
            sentBookResource.setBookId(bookId);
        Book updateBook = bookService.updateBook(sentBookResource.toBook());
        if(updateBook != null)
        {
            BookResource res = new BookResourceAsm().toResource(updateBook);
            return new ResponseEntity<BookResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<BookResource>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<BookResource> createBook(
            @RequestBody BookResource sentBookResource
    ) {
        Book createdBook = sentBookResource.toBook();
        createdBook.setId(null);
        createdBook = bookService.createBook(0L, createdBook);
        BookResource createdBookResource = new BookResourceAsm().toResource(createdBook);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(createdBookResource.getLink("self").getHref()));
        return new ResponseEntity<BookResource>(createdBookResource, headers, HttpStatus.CREATED);

    }



}
