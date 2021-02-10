package pl.coderslab.book.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import pl.coderslab.author.entity.Author;
import pl.coderslab.book.dao.BookDao;
import pl.coderslab.book.entity.Book;
import pl.coderslab.publisher.entity.Publisher;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookDao bookDao;

    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    public Book findById(long id) {
        return bookDao.findById(id);
    }

    public Book findWithAutorsById(long id) {
        Book book = bookDao.findById(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public List<Book> getRatingList(int rating) {
        return bookDao.getRatingList(rating);
    }

    public List<Book> getBookWithPublisher() {
        return bookDao.getBookWithPublisher();
    }

    public List<Book> getBookWithPublisher(Publisher publisher) {
        return bookDao.getBookWithPublisher(publisher);
    }

    public List<Book> getBookWithAuthor(Author author) {
        return bookDao.getBookWithAuthor(author);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void delete(long id) {
        Book book = findById(id);
        bookDao.delete(book);
    }
}
