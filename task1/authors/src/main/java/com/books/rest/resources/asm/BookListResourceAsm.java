package com.books.rest.resources.asm;

import com.books.core.services.util.BookList;
import com.books.rest.mvccontrollers.BookController;
import com.books.rest.resources.BookListResource;
import com.books.rest.resources.BookResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

/**
 * Created by Simba on 2/27/2016.
 */
public class BookListResourceAsm
        extends ResourceAssemblerSupport<BookList, BookListResource> {

    public BookListResourceAsm() {
        super(BookController.class, BookListResource.class);
    }

    @Override
    public BookListResource toResource(BookList bookList) {
        List<BookResource> resList = new BookResourceAsm()
                .toResources(bookList.getBooks());
        BookListResource finalRes = new BookListResource();
        finalRes.setBooks(resList);
        return finalRes;
    }

}
