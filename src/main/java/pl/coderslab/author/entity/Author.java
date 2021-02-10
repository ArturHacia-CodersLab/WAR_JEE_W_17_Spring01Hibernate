package pl.coderslab.author.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = Author.TABLE_NAME)
@NoArgsConstructor
@Data
public class Author {
    public static final String TABLE_NAME = "authors";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
