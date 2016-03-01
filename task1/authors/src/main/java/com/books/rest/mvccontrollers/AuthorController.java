package com.books.rest.mvccontrollers;

import com.books.core.models.Author;
import com.books.core.services.AuthorService;
import com.books.core.services.util.AuthorList;
import com.books.rest.resources.AuthorListResource;
import com.books.rest.resources.AuthorResource;
import com.books.rest.resources.asm.AuthorListResourceAsm;
import com.books.rest.resources.asm.AuthorResourceAsm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Simba on 2/27/2016.
 */
@RestController
@RequestMapping("/rest/authors")
public class AuthorController {


    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(method = RequestMethod.GET )
    public ResponseEntity<AuthorListResource> findAllAuthors
            (@RequestParam(value = "name",
                    required = false) String name ) {
        AuthorList list = null;
        if (name == null) {
            list = authorService.findAllAuthors();
        } else {
            Author author = authorService.findByAuthorName(name);
            list = new AuthorList(new ArrayList<Author>());
            if(author != null) {
                list = new AuthorList(Arrays.asList(author));
            }

        }
        AuthorListResource res = new AuthorListResourceAsm().toResource(list);
        return new ResponseEntity<AuthorListResource>(res, HttpStatus.OK);
    }





    @RequestMapping(value = "/{accountId}",
            method = RequestMethod.GET)
    public ResponseEntity<AuthorResource> getAuthor(
            @PathVariable Long accountId
    ) {
        Author author = authorService.findAuthor(accountId);
        if (author != null) {
            AuthorResource res = new AuthorResourceAsm().toResource(author);
            return new ResponseEntity<AuthorResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<AuthorResource>(HttpStatus.NOT_FOUND);


        }
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AuthorResource> createAuthor(
            @RequestBody AuthorResource sentAuthor
    ) {
            Author createdAuthor=  sentAuthor.toAuthor();
        createdAuthor.setId(null);
             createdAuthor = authorService.createAuthor(createdAuthor);
            AuthorResource res = new AuthorResourceAsm().toResource(createdAuthor);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<AuthorResource>(res, headers, HttpStatus.CREATED);

    }

    @RequestMapping(value="/{authorId}",
            method = RequestMethod.PUT)
    public ResponseEntity<AuthorResource> updateAuthor(
            @PathVariable Long authorId, @RequestBody AuthorResource sentAuthorResource) {
        sentAuthorResource.setAurthorId(authorId);
        Author updatedAuthor = authorService.updateAuthor(sentAuthorResource.toAuthor());
        if(updatedAuthor != null)
        {
            AuthorResource res = new AuthorResourceAsm().toResource(updatedAuthor);
            return new ResponseEntity<AuthorResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<AuthorResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{authorId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<AuthorResource> deleteAuthor(
            @PathVariable Long authorId) {
        Author author = authorService.deleteAuthor(authorId);
        if(author != null)
        {
            AuthorResource res = new AuthorResourceAsm().toResource(author);
            return new ResponseEntity<AuthorResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<AuthorResource>(HttpStatus.NOT_FOUND);
        }
    }


}
