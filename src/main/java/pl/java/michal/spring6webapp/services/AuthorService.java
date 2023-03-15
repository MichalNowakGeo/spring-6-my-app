package pl.java.michal.spring6webapp.services;

import pl.java.michal.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
