package com.books.core.services;

import com.books.core.models.Author;
import com.books.core.services.util.AuthorList;

/**
 * Created by Simba on 2/26/2016.
 */
public interface AuthorService {
    public Author findAuthor(Long id);
    public Author createAuthor(Author data);
    public AuthorList findAllAuthors();
    public Author findByAuthorName(String name);
    public Author updateAuthor( Author data);
    public Author deleteAuthor(Long id);
}
