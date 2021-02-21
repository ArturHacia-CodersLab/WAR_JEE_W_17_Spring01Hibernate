package pl.coderslab.book.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import pl.coderslab.author.entity.Author;
import pl.coderslab.category.entity.Category;
import pl.coderslab.publisher.entity.Publisher;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotNull
    @Size(min = 5, max = 100)
    private String title;

    @Range(min = 1, max = 10)
    private int rating;

    @Size(max = 600)
    private String description;

    @ManyToOne
    @NotNull
    private Publisher publisher;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    @NotEmpty
    private List<Author> authors;

    @Min(1)
    private int pages;

    @ManyToOne
    @NotNull
    private Category category;
}
