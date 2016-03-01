package com.books.core.repositories;

import com.books.core.models.Author;

import java.util.List;

/**
 * Created by Simba on 2/26/2016.
 */
public interface AuthorDao {
    public List<Author> findAllAuthors();
    public Author findAuthor(Long id);
    public Author findAuthorByName(String name);
    public Author createAuthor(Author data);
    public Author updateAuthor( Author data);

    public Author deleteAuthor(Long id);
}
