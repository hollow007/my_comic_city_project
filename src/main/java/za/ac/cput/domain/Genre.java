package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;


    protected Genre() {}


    private Genre(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;
        Genre genre = (Genre) o;
        return Objects.equals(id, genre.id) &&
                Objects.equals(name, genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public static class Builder {
        private Long id;
        private String name;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder copy(Genre genre) {
            this.id = genre.id;
            this.name = genre.name;
            return this;
        }

        public Genre build() {
            return new Genre(this);
        }
    }
}
