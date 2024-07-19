package za.ac.cput.service.comicBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ComicBook;

import za.ac.cput.repository.AuthorRepository;
import za.ac.cput.repository.ComicBookRepository;
import za.ac.cput.service.authorService.AuthorService;

import java.util.List;
@Service
public class ComicBookService implements IComicBookService{
    @Autowired
    private ComicBookRepository repo;


    @Override
    public ComicBook create(ComicBook comicBook) {

        System.out.println("Creating ComicBook: " + comicBook);

        ComicBook savedComicBook = repo.save(comicBook);

        System.out.println("Saved ComicBook: " + savedComicBook);
        return savedComicBook;
    }

    @Override
    public ComicBook read(Long s) {
        return repo.findById(s).orElse(null);
    }

    @Override
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
}
