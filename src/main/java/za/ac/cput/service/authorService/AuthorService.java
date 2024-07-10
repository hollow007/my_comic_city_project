package za.ac.cput.service.authorService;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Author;
import za.ac.cput.repository.AuthorRepository;

import java.util.List;
@Service
public class AuthorService implements IAuthorService{
    @Autowired
    private AuthorRepository repo;
    @Override
    public Author create(Author author) {
        return repo.save(author);
    }

    @Override
    public Author read(Long l) {
        return repo.findById(l).orElse(null);
    }

    @Override
    public Author update(Author author) {
        return repo.save(author);
    }

    @Override
    public boolean delete(Long l) {
       repo.deleteById(l);
       return !repo.existsById(l);
    }

    @Override
    public List<Author> getAll() {
        return repo.findAll();
    }
}
