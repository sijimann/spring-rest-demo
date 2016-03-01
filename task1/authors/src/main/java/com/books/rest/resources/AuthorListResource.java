package com.books.rest.resources;


import javax.xml.bind.annotation.XmlElement;
import org.springframework.hateoas.ResourceSupport;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simba on 2/27/2016.
 */
@XmlRootElement(name = "AuthorList")
public class AuthorListResource extends ResourceSupport {



    private List<AuthorResource> authors = new ArrayList<AuthorResource>();


    public List<AuthorResource> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorResource> authors) {
        this.authors = authors;
    }
}
