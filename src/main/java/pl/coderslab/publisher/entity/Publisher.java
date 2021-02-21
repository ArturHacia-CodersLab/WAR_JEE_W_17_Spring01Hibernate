package pl.coderslab.publisher.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = Publisher.TABLE_NAME)
@NoArgsConstructor
@Data
public class Publisher {
    public static final String TABLE_NAME = "publishers";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    @NIP
    private String nip;

    @REGON
    private String regon;
}
