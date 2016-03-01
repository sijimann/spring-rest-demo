package com.books.rest.resources.asm;

import com.books.core.services.util.AuthorList;
import com.books.rest.mvccontrollers.AuthorController;
import com.books.rest.resources.AuthorListResource;
import com.books.rest.resources.AuthorResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.net.URI;
import java.util.List;

/**
 * Created by Simba on 2/27/2016.
 */
public class AuthorListResourceAsm
        extends ResourceAssemblerSupport<AuthorList, AuthorListResource> {
    public AuthorListResourceAsm() {
        super(AuthorController.class, AuthorListResource.class);
    }

    @Override
    public AuthorListResource toResource(AuthorList authorList) {
        List<AuthorResource> resList = new AuthorResourceAsm()
                .toResources(authorList.getAuthors());
        AuthorListResource finalRes = new AuthorListResource();
        finalRes.setAuthors(resList);
        return finalRes;
    }






}
