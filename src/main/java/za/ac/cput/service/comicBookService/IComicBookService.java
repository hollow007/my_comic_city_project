package za.ac.cput.service.comicBookService;

import za.ac.cput.domain.ComicBook;
import za.ac.cput.service.IService;

import java.util.List;

public interface IComicBookService extends IService<ComicBook, String> {
    List<ComicBook> getAll();
 }
