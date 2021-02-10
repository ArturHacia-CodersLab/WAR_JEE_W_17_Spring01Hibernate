package pl.coderslab.publisher.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.coderslab.book.entity.Book;

import javax.persistence.*;

@Entity
@Table(name = Publisher.TABLE_NAME)
@NoArgsConstructor
@Data
public class Publisher {
    public static final String TABLE_NAME = "publishers";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
}
