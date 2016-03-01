package com.mvc;

import com.books.core.models.Author;
import com.books.core.services.AuthorService;
import com.books.core.services.util.AuthorList;
import com.books.rest.mvccontrollers.AuthorController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Simba on 2/27/2016.
 */
public class AuthorControllerTest {
    @InjectMocks
    private com.books.rest.mvccontrollers.AuthorController controller;

    @Mock
    private AuthorService service;

    private MockMvc mockMvc;

    private ArgumentCaptor<Author> authorArgumentCaptor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        authorArgumentCaptor = ArgumentCaptor.forClass(Author.class);
    }


    @Test
    public void findAllAccounts() throws Exception {
        List<Author> authors = new ArrayList<Author>();

        for(int x=1;x<=5;x++){
            Author author= new Author();
            author.setPublisherName("publisher "+x);
            author.setSurname("surname "+x);
            author.setFirstName("firname "+x);
            author.setId(new Long(x));
        }
        AuthorList authorList = new AuthorList(authors);
        when(service.findAllAuthors()).thenReturn(authorList);

        mockMvc.perform(get("/rest/authors"))
                .andExpect(jsonPath("$.authors[*].name",
                        hasItems(endsWith("author"), endsWith("accountB"))))
                .andExpect(status().isOk());
    }



}
