package pl.java.michal.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.java.michal.spring6webapp.domain.Author;
import pl.java.michal.spring6webapp.domain.Book;
import pl.java.michal.spring6webapp.domain.Publisher;
import pl.java.michal.spring6webapp.repositories.AuthorRepository;
import pl.java.michal.spring6webapp.repositories.BookRepository;
import pl.java.michal.spring6webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        Publisher helion = new Publisher();
        helion.setPublisherName("Helion");
        helion.setCity("Gliwice");
        helion.setAddress("Kościuszki 1c");
        helion.setZip("44-100");
        Publisher helionSaved = publisherRepository.save(helion);

        dddSaved.setPublisher(helionSaved);
        noEJBSaved.setPublisher(helionSaved);

        authorRepository.save(rodSaved);

        authorRepository.save(ericSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}
