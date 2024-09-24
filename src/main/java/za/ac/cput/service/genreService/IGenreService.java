package za.ac.cput.service.genreService;

import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Genre;
import za.ac.cput.service.IService;

import java.util.List;

public interface IGenreService extends IService<Genre, Long> {
    List<Genre> getAll();
}
