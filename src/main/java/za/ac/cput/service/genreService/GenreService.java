package za.ac.cput.service.genreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Genre;
import za.ac.cput.repository.GenreRepository;

import java.util.List;


@Service
public class GenreService implements IGenreService{

    @Autowired
    GenreRepository genreRepository;

    @Override
    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre read(Long aLong) {
        return read(aLong);
    }


    @Override
    public Genre update(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public boolean delete(Long aLong) {
        genreRepository.deleteById(aLong);
        return !genreRepository.existsById(aLong);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }
}
