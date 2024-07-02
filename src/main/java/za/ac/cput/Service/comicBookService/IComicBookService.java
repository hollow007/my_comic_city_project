package za.ac.cput.service.comicBookService;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.service.IService;

import java.util.List;
@Service
public interface IComicBookService extends IService<ComicBook, Long> {
    List<ComicBook> getAll();
 }
