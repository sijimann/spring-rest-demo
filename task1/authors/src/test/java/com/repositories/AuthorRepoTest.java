package com.repositories;

import com.books.WebConfig;
import com.books.core.models.Author;
import com.books.core.services.AuthorService;
import com.books.core.services.util.AuthorList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Simba on 2/27/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=WebConfig.class)
@WebAppConfiguration
public class AuthorRepoTest {

    @Autowired
    private AuthorService service;

    private Author author;
    
    @Before
    @Transactional
    @Rollback(false)
    public void setup()
    {
        author = new Author();
        author.setFirstName("simba");
        author.setSurname("surname");
        author.setPublisherName("publishername");
        service.createAuthor(author);

    }

    @Test
    @Transactional
    public void testFind()
    {
        Author a = service.findAuthor(this.author.getId());
        assertNotNull(a);
        assertEquals(a.getFirstName(), "simba");
        assertEquals(a.getSurname(), "surname");
    }


    @Test
    @Transactional
    public void testFindAll(){
        AuthorList authorList=service.findAllAuthors();
        assertNotNull(authorList.getAuthors());
    }

    @Test
    @Transactional
    public void testFindByName(){
        Author a=service.findByAuthorName("simba");
        assertNotNull(a);
        //assertEquals(a.getSurname(), "surname");
    }
}
