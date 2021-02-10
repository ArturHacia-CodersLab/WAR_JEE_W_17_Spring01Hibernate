package pl.coderslab.book.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.coderslab.author.entity.Author;
import pl.coderslab.publisher.entity.Publisher;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Book.TABLE_NAME)
@NoArgsConstructor
@Data
public class Book {
    public static final String TABLE_NAME = "books";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100)
    private String title;
    private int rating;
    private String description;
    @ManyToOne
    private Publisher publisher;
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;
}
