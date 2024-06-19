package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.service.publisherService.PublisherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Publisher {
    @Id
    private Long publisherId;
    private String name;
    private int yearFounded;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<ComicBook> comicBooks;
    protected Publisher(){}


    private Publisher(PublisherBuilder builder){
        this.publisherId = builder.publisherId;
        this.name = builder.name;
        this.yearFounded = builder.yearFounded;
        this.comicBooks = builder.comicBooks;
    }

    public long getPublisherId(){
        return publisherId;
    }
    public String getName(){return name;}

    public int getYearFounded(){return yearFounded;}

    public List<ComicBook> getComicBooks() {
        return comicBooks;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", name='" + name + '\'' +
                ", yearFounded=" + yearFounded +
                ", comicBooks=" + comicBooks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return publisherId == publisher.publisherId && yearFounded == publisher.yearFounded && Objects.equals(name, publisher.name) && Objects.equals(comicBooks, publisher.comicBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId, name, yearFounded, comicBooks);
    }

    public static class PublisherBuilder{
        private long publisherId;
        private String name;
        private int yearFounded;
        private List<ComicBook> comicBooks;

        public PublisherBuilder(){}

        public PublisherBuilder setPublisherId(long publisherId) {
            this.publisherId = publisherId;
            return this;
        }

        public PublisherBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PublisherBuilder setYearFounded(int yearFounded) {
            this.yearFounded = yearFounded;
            return this;
        }

        public PublisherBuilder setComicBooks(List<ComicBook> comicBooks) {
            this.comicBooks = comicBooks;
            return this;
        }

        public PublisherBuilder copy(Publisher p){
            this.publisherId = p.publisherId;
            this.name = p.name;
            this.yearFounded = p.yearFounded;
            this.comicBooks = p.comicBooks;
            return this;
        }

        public Publisher build(){
            return new Publisher(this);
        }
    }
}
