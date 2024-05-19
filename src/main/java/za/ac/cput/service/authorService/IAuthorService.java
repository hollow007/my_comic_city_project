package za.ac.cput.service.authorService;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Author;
import za.ac.cput.service.IService;

import java.util.List;
@Service
public interface IAuthorService extends IService<Author, Long> {
    List<Author> getAll();
}
