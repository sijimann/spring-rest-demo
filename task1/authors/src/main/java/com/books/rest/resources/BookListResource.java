package com.books.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simba on 2/27/2016.
 */
@XmlRootElement(name = "BookList")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookListResource extends ResourceSupport {

    private List<BookResource> books = new ArrayList<BookResource>();

    public List<BookResource> getBooks() {
        return books;
    }

    public void setBooks(List<BookResource> books) {
        this.books = books;
    }
}
