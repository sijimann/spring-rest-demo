package com.books.rest.resources.asm;

import com.books.core.models.Book;
import com.books.rest.mvccontrollers.AuthorController;
import com.books.rest.mvccontrollers.BookController;
import com.books.rest.resources.AuthorResource;
import com.books.rest.resources.BookResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Simba on 2/27/2016.
 */
public class BookResourceAsm
        extends ResourceAssemblerSupport<Book, BookResource> {

    public BookResourceAsm() {
        super(BookController.class, BookResource.class);
    }

    @Override
    public BookResource toResource(Book book) {
        BookResource res = new BookResource();
           res.setPublishDate(book.getPublishDate());
        res.setTitle(book.getTitle());
        res.setSynopsis(book.getSynopsis());
        res.setBookId(book.getId());
        if(book.getAuthor()!=null) {
            AuthorResource authorResource = new AuthorBookResourceAsm().toResource(book.getAuthor());
            res.setAuthorBook(authorResource);
        }

        Link self = linkTo(BookController.class).slash(book.getId()).withSelfRel();
        res.add(self);
        if(book.getAuthor() != null)
        {
            res.add(linkTo(methodOn(AuthorController.class).getAuthor(book.getAuthor().getId())).withSelfRel());
        }
        return res;
    }
}
