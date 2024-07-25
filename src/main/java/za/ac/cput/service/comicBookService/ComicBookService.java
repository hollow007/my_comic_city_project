package za.ac.cput.service.comicBookService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.ComicBook;

import za.ac.cput.domain.Publisher;
import za.ac.cput.repository.AuthorRepository;
import za.ac.cput.repository.ComicBookRepository;
import za.ac.cput.repository.PublisherRepository;
import za.ac.cput.service.authorService.AuthorService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComicBookService implements IComicBookService{
    @Autowired
    private ComicBookRepository repo;  // Use 'repo' as the name for ComicBookRepository

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public ComicBook create(ComicBook comicBook) {
        // Handle Publisher
        Publisher publisher = comicBook.getPublisher();
        if (publisher != null) {
            Optional<Publisher> existingPublisher = publisherRepository.findById(publisher.getPublisherId());
            if (existingPublisher.isPresent()) {
                publisher = existingPublisher.get();
            } else {
                publisher = publisherRepository.save(publisher);
            }
        }

        // Handle Authors
        List<Author> authors = comicBook.getAuthors();
        if (authors != null) {
            authors = authors.stream()
                    .map(author -> {
                        Optional<Author> existingAuthor = authorRepository.findById(author.getAuthorID());
                        return existingAuthor.orElseGet(() -> authorRepository.save(author));
                    })
                    .collect(Collectors.toList());
        }

        ComicBook updatedComicBook = new ComicBook.Builder()
                .copy(comicBook)
                .setPublisher(publisher)
                .setAuthors(authors)
                .build();

        return repo.save(updatedComicBook);  // Use 'repo' to save the ComicBook
    }
    @Override
    public ComicBook read(Long s) {
        return repo.findById(s).orElse(null);
    }

    @Transactional
    public ComicBook update(ComicBook comicBook) {
        // Handle Publisher
        Publisher publisher = comicBook.getPublisher();
        if (publisher != null) {
            Optional<Publisher> existingPublisher = publisherRepository.findById(publisher.getPublisherId());
            if (existingPublisher.isPresent()) {
                publisher = existingPublisher.get();
            } else {
                // Save new Publisher if it does not exist
                publisher = publisherRepository.save(publisher);
            }
        }

        // Handle Authors
        List<Author> authors = comicBook.getAuthors();
        if (authors != null) {
            authors = authors.stream()
                    .map(author -> {
                        Optional<Author> existingAuthor = authorRepository.findById(author.getAuthorID());
                        return existingAuthor.orElseGet(() -> authorRepository.save(author));
                    })
                    .collect(Collectors.toList());
        }

        // Create updated ComicBook with the managed entities
        ComicBook updatedComicBook = new ComicBook.Builder()
                .copy(comicBook)
                .setPublisher(publisher)
                .setAuthors(authors)
                .build();

        // Save updated ComicBook
        return repo.save(updatedComicBook);
    }

    @Override
    public boolean delete(Long s) {
        repo.deleteById(s);
        return !repo.existsById(s);
    }

    @Override
    public List<ComicBook> getAll() {
        return repo.findAll();
    }
}
