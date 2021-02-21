package pl.coderslab.author.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = Author.TABLE_NAME)
@NoArgsConstructor
@Data

public class Author {
    public static final String TABLE_NAME = "authors";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @PESEL
    private String pesel;

    @NotBlank
    @Email
    private String email;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
