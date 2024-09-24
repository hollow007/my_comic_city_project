package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Genre;
import za.ac.cput.service.genreService.GenreService;
import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping("/create")
    public Genre createGenre(@RequestBody Genre genre) {
        Genre savedGenre = genreService.create(genre);
        return savedGenre;
    }

    @GetMapping("/getAll")
    public List<Genre> getAllGenres() {
        List<Genre> genres = genreService.getAll();
        return genres;
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteGenre(@PathVariable("id") Long id) {
        return genreService.delete(id);
    }
}
