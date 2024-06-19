package za.ac.cput.domain;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comic_books")
public class ComicBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SKU;

    private String name;

    private String description;

    private double weight;

    private LocalDate releaseDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "comic_book_author",
            joinColumns = @JoinColumn(name = "comic_book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();

    @ManyToMany
    private List<Cart> carts = new ArrayList<>();

    @ManyToMany
    private List<WishList> wishLists = new ArrayList<>();

    private double price;

    private int stockQuantity;

    private String ISBN;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private String genre;

    @Lob
    @Column(length=100000)
    private byte[] photo;
    protected ComicBook() {

    }

    private ComicBook(Builder builder) {
        this.SKU = builder.SKU;
        this.name = builder.name;
        this.description = builder.description;
        this.weight = builder.weight;
        this.releaseDate = builder.releaseDate;
        this.authors = builder.authors;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
        this.ISBN = builder.ISBN;
        this.publisher = builder.publisher;
        this.genre = builder.genre;
        this.photo = builder.photo;
    }


    public Long getSKU() { return SKU; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getWeight() { return weight; }
    public LocalDate getReleaseDate() { return releaseDate; }
    public List<Author> getAuthors() { return authors; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public String getISBN() { return ISBN; }
    public Publisher getPublisher() { return publisher; }
    public String getGenre() { return genre; }

    @Override
    public String toString() {
        return "ComicBook{" +
                "SKU=" + SKU +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", releaseDate=" + releaseDate +
                ", authors=" + authors +
                ", carts=" + carts +
                ", wishLists=" + wishLists +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", ISBN='" + ISBN + '\'' +
                ", publisher=" + publisher +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComicBook comicBook = (ComicBook) o;
        return Double.compare(weight, comicBook.weight) == 0 && Double.compare(price, comicBook.price) == 0 && stockQuantity == comicBook.stockQuantity && Objects.equals(SKU, comicBook.SKU) && Objects.equals(name, comicBook.name) && Objects.equals(description, comicBook.description) && Objects.equals(releaseDate, comicBook.releaseDate) && Objects.equals(authors, comicBook.authors) && Objects.equals(carts, comicBook.carts) && Objects.equals(wishLists, comicBook.wishLists) && Objects.equals(ISBN, comicBook.ISBN) && Objects.equals(publisher, comicBook.publisher) && Objects.equals(genre, comicBook.genre) && Arrays.equals(photo, comicBook.photo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(SKU, name, description, weight, releaseDate, authors, carts, wishLists, price, stockQuantity, ISBN, publisher, genre);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    public static class Builder {
        private Long SKU;
        private String name;
        private String description;
        private double weight;
        private LocalDate releaseDate;
        private List<Author> authors = new ArrayList<>();
        private double price;
        private int stockQuantity;
        private String ISBN;
        private Publisher publisher;
        private String genre;
        private byte[] photo;


        public Builder SKU(Long SKU) {
            this.SKU = SKU;
            return this;
        }

       public Builder(){}

        public Builder copy(ComicBook c) {
            this.SKU = c.SKU;
            this.name = c.name;
            this.description = c.description;
            this.weight = c.weight;
            this.releaseDate = c.releaseDate;
            this.authors = c.authors;
            this.price = c.price;
            this.stockQuantity = c.stockQuantity;
            this.ISBN = c.ISBN;
            this.publisher = c.publisher;
            this.genre = c.genre;
            this.photo = c.photo;

            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder releaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder authors(List<Author> authors) {
            this.authors = authors;
            return this;
        }



        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder stockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public Builder ISBN(String ISBN) {
            this.ISBN = ISBN;
            return this;
        }

        public Builder publisher(Publisher publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder category(String genre) {
            this.genre = genre;
            return this;
        }
        public Builder setPhoto(byte[] photo) {
            this.photo = photo;
            return this;
        }

        public ComicBook build() {
            return new ComicBook(this);
        }
    }
}

