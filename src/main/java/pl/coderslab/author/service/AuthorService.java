package pl.coderslab.author.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.author.dao.AuthorDao;
import pl.coderslab.author.entity.Author;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorDao authorDao;

    public void saveAuthor(Author author) {
        authorDao.saveAuthor(author);
    }

    public Author findById(long id) {
        return authorDao.findById(id);
    }

    public List<Author> getAllAutors() {
        return authorDao.getAllAutors();
    }

    public void update(Author author) {
        authorDao.update(author);
    }

    public void delete(long id) {
        Author author = findById(id);
        authorDao.delete(author);
    }
}
