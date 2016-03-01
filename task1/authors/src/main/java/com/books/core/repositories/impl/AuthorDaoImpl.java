package com.books.core.repositories.impl;

import com.books.core.models.Author;
import com.books.core.repositories.AuthorDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Simba on 2/26/2016.
 */
@Repository
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Author> findAllAuthors() {
        Query query = em.createQuery("SELECT a FROM Author a");
        return query.getResultList();
    }

    @Override
    public Author findAuthor(Long id) {
        return em.find(Author.class, id);
    }

    @Override
    public Author findAuthorByName(String name) {
        Query query = em.createQuery("SELECT a FROM Author a WHERE a.firstName=?1");
        query.setParameter(1, name);
        List<Author> authors = query.getResultList();
        if(authors.size() == 0) {
            return null;
        } else {
            return authors.get(0);
        }
    }

    @Override
    public Author createAuthor(Author data) {
        em.persist(data);
        return data;
    }

    @Override
    public Author updateAuthor(Author data) {
        Author entry = em.find(Author.class, data.getId());
        entry.setFirstName(data.getFirstName());
        entry.setPublisherName(data.getPublisherName());
        entry.setSurname(data.getSurname());
        return entry;
    }

    @Override
    public Author deleteAuthor(Long id) {
        Author author= em.find(Author.class,id);
        if(author!=null){
            em.remove(author);
        }

        return author;
    }
}
