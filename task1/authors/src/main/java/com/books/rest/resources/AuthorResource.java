package com.books.rest.resources;

import com.books.core.models.Author;
import org.springframework.hateoas.ResourceSupport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Simba on 2/27/2016.
 */
@XmlRootElement(name = "author")
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthorResource extends ResourceSupport {

    private Long aurthorId;
    private String firstName;
    private String surname;
    private String publisherName;
    private BookListResource authorBooks;

    public BookListResource getAuthorBooks() {
        return authorBooks;
    }

    public void setAuthorBooks(BookListResource authorBooks) {
        this.authorBooks = authorBooks;
    }

    public Long getAurthorId() {
        return aurthorId;
    }

    public void setAurthorId(Long aurthorId) {
        this.aurthorId = aurthorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Author toAuthor(){
        Author author= new Author();
        author.setFirstName(this.firstName);
        author.setId(this.getAurthorId());
        author.setPublisherName(this.publisherName);
        author.setSurname(this.surname);

        return author;
    }
}
