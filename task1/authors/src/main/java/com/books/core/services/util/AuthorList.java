package com.books.core.services.util;

import com.books.core.models.Author;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simba on 2/27/2016.
 */
public class AuthorList {
    private List<Author> authors = new ArrayList<Author>();

    public AuthorList(List<Author> authors) {
        this.authors = authors;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
