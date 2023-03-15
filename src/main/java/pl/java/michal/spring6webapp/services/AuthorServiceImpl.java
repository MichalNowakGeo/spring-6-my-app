package pl.java.michal.spring6webapp.services;

import org.springframework.stereotype.Service;
import pl.java.michal.spring6webapp.domain.Author;
import pl.java.michal.spring6webapp.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
