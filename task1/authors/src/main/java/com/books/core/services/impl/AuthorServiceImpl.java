package com.books.core.services.impl;

import com.books.core.models.Author;
import com.books.core.repositories.AuthorDao;
import com.books.core.services.AuthorService;
import com.books.core.services.util.AuthorList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Simba on 2/27/2016.
 */
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author findAuthor(Long id) {
        return authorDao.findAuthor(id);
    }

    @Override
    public Author createAuthor(Author data) {
        return authorDao.createAuthor(data);
    }

    @Override
    public AuthorList findAllAuthors() {
        return new AuthorList(authorDao.findAllAuthors());
    }

    @Override
    public Author findByAuthorName(String name) {
        return authorDao.findAuthorByName(name);
    }

    @Override
    public Author updateAuthor(Author data) {
        return authorDao.updateAuthor(data);
    }

    @Override
    public Author deleteAuthor(Long id) {
       return authorDao.deleteAuthor(id);
    }
}
