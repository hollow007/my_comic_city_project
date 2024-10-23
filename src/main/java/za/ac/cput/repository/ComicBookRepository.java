
package za.ac.cput.repository;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Genre;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface ComicBookRepository extends JpaRepository<ComicBook, Long> {
    List<ComicBook> findByNameContainingIgnoreCase(String name);
    List<ComicBook> findBySku(Long sku);
    List<ComicBook> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate);
    @Query("SELECT c FROM ComicBook c JOIN c.genres g WHERE g.name IN :genreNames")
    List<ComicBook> findByGenreNamesIn(@Param("genreNames") Set<String> genreNames);
//    List<ComicBook>findByPublisher(@Param("publisher")String publisher);
    List<ComicBook>findComicBooksByPublisher_Name(String publisher);
    List<ComicBook>findComicBooksByPriceLessThanEqual(Double price);


}
