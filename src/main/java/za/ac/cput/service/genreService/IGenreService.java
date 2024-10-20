package za.ac.cput.service.genreService;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Genre;
import za.ac.cput.service.IService;

import java.util.List;
@Service
public interface IGenreService extends IService<Genre, Long> {
    List<Genre> getAll();
}
