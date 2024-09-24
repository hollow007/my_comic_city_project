package za.ac.cput.service.comicBookService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.ComicBook;

import za.ac.cput.domain.Genre;
import za.ac.cput.domain.Publisher;
import za.ac.cput.factory.AuthorFactory;
import za.ac.cput.repository.AuthorRepository;
import za.ac.cput.repository.ComicBookRepository;
import za.ac.cput.repository.PublisherRepository;
import za.ac.cput.service.authorService.AuthorService;
import za.ac.cput.service.publisherService.PublisherService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ComicBookService implements IComicBookService{
    @Autowired
    private ComicBookRepository repo;

    //@Transactional
    public ComicBook create(ComicBook comicBook) {
        return repo.save(comicBook);
    }
    @Override
    public ComicBook read(Long s) {
        return repo.findById(s).orElse(null);
    }

    //@Transactional
    public ComicBook update(ComicBook comicBook) {
        return repo.save(comicBook);
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

    public List<ComicBook> findByNameContainingIgnoreCase(String name){
        return repo.findByNameContainingIgnoreCase(name);
    }
    public List<ComicBook> findBySku(Long sku){
        return repo.findBySku(sku);
    }

    public List<ComicBook> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate){
        return repo.findByReleaseDateBetween(startDate, endDate);
    }

    public List<ComicBook> findByGenreNamesIn( Set<String> genres){
        return repo.findByGenreNamesIn(genres);
    }
}

