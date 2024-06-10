package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "publishing_houses")
public class PublishingHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publishing_houses_seq")
    @SequenceGenerator(name = "publishing_houses_seq", sequenceName = "publishing_houses_sequence", allocationSize = 1)
    private Integer id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "books_publishing_houses_jt",
            joinColumns = @JoinColumn(name = "publishing_house_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

    public PublishingHouse() {
    }

    public PublishingHouse(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "PublishingHouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
