package pl.java.michal.spring6webapp.services;

import pl.java.michal.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
