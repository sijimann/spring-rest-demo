package com.books.rest.resources.asm;

import com.books.core.models.Author;
import com.books.rest.mvccontrollers.AuthorController;
import com.books.rest.resources.AuthorResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Simba on 2/29/2016.
 */
public class AuthorBookResourceAsm   extends ResourceAssemblerSupport<Author, AuthorResource> {
    public AuthorBookResourceAsm() {
        super(AuthorController.class, AuthorResource.class);
    }

    @Override
    public AuthorResource toResource(Author author) {
        AuthorResource res = new AuthorResource();
        res.setPublisherName(author.getPublisherName());
        res.setSurname(author.getSurname());
        res.setFirstName(author.getFirstName());
        res.setAurthorId(author.getId());
        //BookList bookList= new BookList(author.getBooks());
        //res.setAuthorBooks(new BookListResourceAsm().toResource(bookList));
        res.add(linkTo(methodOn(AuthorController.class).getAuthor(author.getId())).withSelfRel());
        //res.add(linkTo(methodOn(AuthorController.class).findAllBlogs(author.getId())).withRel("blogs"));
        return res;
    }

}
