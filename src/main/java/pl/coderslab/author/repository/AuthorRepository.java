package pl.coderslab.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.author.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("select a from Author a where a.email like ?1%")
    List<Author> findAuthorsByEmailBegin(String email);

    @Query("select a from Author a where a.pesel like ?1%")
    List<Author> findAutorsByPeselBegin(String pesel);
}
