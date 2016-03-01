package com.books.rest.resources;

import com.books.core.models.Author;
import com.books.core.models.Book;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.sun.istack.internal.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.ResourceSupport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Simba on 2/27/2016.
 */
@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookResource extends ResourceSupport {
    private Long bookId;

    private String title;

    private String synopsis;

    @DateTimeFormat(pattern="dd-MM-yyyy")
    @JsonSerialize(using=DateSerializer.class)
    private Date publishDate;

    private AuthorResource authorBook;

    public AuthorResource getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(AuthorResource authorBook) {
        this.authorBook = authorBook;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Book toBook(){
        Book book= new Book();
        book.setTitle(this.getTitle());
       // Date date =Date.from(publishDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        book.setPublishDate(this.publishDate);
        book.setSynopsis(this.getSynopsis());
        if(this.getBookId()!=0) {
            book.setId(this.getBookId());
        }
        return book;
    }
}
