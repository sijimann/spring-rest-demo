package com.books.core.repositories.impl;

import com.books.core.models.Author;
import com.books.core.models.Book;
import com.books.core.repositories.BookDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Simba on 2/26/2016.
 */
@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> findAllBooks() {
        Query query = em.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }

    @Override
    public Book findBook(Long id) {
        return em.find(Book.class, id);
    }

    @Override
    public Book findBookByTitle(String name) {
        Query query = em.createQuery("SELECT b FROM Book b WHERE b.title=?1");
        query.setParameter(1, name);
        List<Book> books = query.getResultList();
        if(books.size() == 0) {
            return null;
        } else {
            return books.get(0);
        }
    }

    @Override
    public Book createBook(Book data) {
        em.persist(data);
        return data;
    }

    @Override
    public List<Book> findBooksByAuthor(Long id) {
        Query query = em.createQuery("SELECT b FROM Book b WHERE b.author.id=?1");
        query.setParameter(1, id);
        List<Book> books = query.getResultList();
        if(books.size() == 0) {
            return null;
        } else {
            return books;
        }
    }

    @Override
    public Book deleteBook(Long id) {
        Book book= em.find(Book.class,id);
        if(book!=null) {
            em.remove(book);
        }
        return book;
    }

    @Override
    public Book updateBook(Book data) {
        Book entry = em.find(Book.class, data.getId());
        entry.setPublishDate(data.getPublishDate());
        entry.setSynopsis(data.getSynopsis());
        entry.setTitle(data.getTitle());
        return entry;
    }
}
