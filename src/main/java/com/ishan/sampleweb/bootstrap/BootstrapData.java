package com.ishan.sampleweb.bootstrap;

import com.ishan.sampleweb.domain.Author;
import com.ishan.sampleweb.domain.Book;
import com.ishan.sampleweb.domain.Publisher;
import com.ishan.sampleweb.repository.AuthorRepository;
import com.ishan.sampleweb.repository.BookRepository;
import com.ishan.sampleweb.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Brooke");

        Book bdd = new Book();
        bdd.setTitle("Domain Driven Testing");
        bdd.setIsbn("12345");

        Author ericSaved = authorRepository.save(eric);
        Book bddSaved = bookRepository.save(bdd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Jonson");

        Book tdd = new Book();
        tdd.setTitle("Test Driven Development");
        tdd.setIsbn("678910");

        Publisher ishan = new Publisher();
        ishan.setName("Ishan");
        ishan.setAddress("manhatton, new york");
        ishan.setCity("New york");
        ishan.setZip("222");

        Publisher publisherSaved = publisherRepository.save(ishan);

        Author rodSaved = authorRepository.save(rod);
        Book tddSaved = bookRepository.save(tdd);

        tdd.setPublisher(publisherSaved);
        bdd.setPublisher(publisherSaved);

        ericSaved.getBooks().add(bddSaved);
        rodSaved.getBooks().add(tddSaved);
        tddSaved.getAuthors().add(ericSaved);
        bddSaved.getAuthors().add(rodSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(tddSaved);
        bookRepository.save(bddSaved);

        System.out.println("Bootstrapping ...");
        System.out.println("Authors count : " + authorRepository.count());
        System.out.println("Books count : " + bookRepository.count());
        System.out.println("Publishers count : " + publisherRepository.count());

    }
}
