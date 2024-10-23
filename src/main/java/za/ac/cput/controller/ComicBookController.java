package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Genre;
import za.ac.cput.service.comicBookService.ComicBookService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/comic_book")
@CrossOrigin(origins = "http://localhost:3000")
public class ComicBookController {

    @Autowired
    private ComicBookService comicBookService;

    @PostMapping("/create")
    //@PreAuthorize("hasRole('ADMIN')")
    public ComicBook create(@RequestBody ComicBook comicBook) {
        System.out.println("Entered Comic book");
        System.out.println(comicBook);
        ComicBook savedComicBook = comicBookService.create(comicBook);
        return savedComicBook;
    }

    @GetMapping("/read/{sku}")
    public ResponseEntity<ComicBook> read(@PathVariable("sku") Long sku) {
        if (sku == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ComicBook comicBook = comicBookService.read(sku);

        if (comicBook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comicBook, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ComicBook update(@RequestBody ComicBook comicBook) {
        return comicBookService.update(comicBook);
    }

    @DeleteMapping("/delete/{sku}")
    public boolean delete(@PathVariable("sku") Long sku) {
        return comicBookService.delete(sku);
    }

    @GetMapping("/getAll")
    public List<ComicBook> getAll() {
        return comicBookService.getAll();
    }

    @GetMapping("/search/name/{name}")
    public ResponseEntity<List<ComicBook>> findByNameContainingIgnoreCase(@PathVariable("name") String name) {
        List<ComicBook> comicBooks = comicBookService.findByNameContainingIgnoreCase(name);
        return new ResponseEntity<>(comicBooks, HttpStatus.OK);
    }

    @GetMapping("/search/releaseDates/{startDate}/{endDate}")
    public ResponseEntity<List<ComicBook>> findByReleaseDateBetween(
          @PathVariable("startDate") LocalDate startDate,
           @PathVariable("endDate") LocalDate endDate) {
        List<ComicBook> comicBooks = comicBookService.findByReleaseDateBetween(startDate, endDate);
        return new ResponseEntity<>(comicBooks, HttpStatus.OK);
    }

    //    @GetMapping("/search/genres")
//    public ResponseEntity<List<ComicBook>> findByGenresIn(@RequestParam("genres") Set<Genre> genres) {
//        List<ComicBook> comicBooks = comicBookService.findByGenresIn(genres);
//        return new ResponseEntity<>(comicBooks, HttpStatus.OK);
//    }
    @GetMapping("/search/genres")
    public List<ComicBook> getComicBooksByGenres(@RequestParam List<String> genres) {
        System.out.print("HIIIII");
        System.out.println(genres.toString());
        Set<String> genreSet = new HashSet<>(genres);
        System.out.println(genreSet.toString());
        List<ComicBook> comicBooks = comicBookService.findByGenreNamesIn(genreSet);
        System.out.println(comicBooks.toString());

        return comicBooks;
    }


    @GetMapping("/filter/publisher/{publisher}")
    public List<ComicBook> findByPublisherContainingIgnoreCase(@PathVariable("publisher") String publisher) {
        return comicBookService.findByBooksPublisher(publisher);
    }
    @GetMapping("/filter/price/{price}")
    public List<ComicBook> findByPriceLessThanEqual(@PathVariable("price") double price) {
        return comicBookService.findByPriceLessThanEqual(price);
    }
}
