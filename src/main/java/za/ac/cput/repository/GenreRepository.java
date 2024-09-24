package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
