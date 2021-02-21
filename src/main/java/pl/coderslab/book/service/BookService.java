package pl.coderslab.book.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import pl.coderslab.author.entity.Author;
import pl.coderslab.book.dao.BookDao;
import pl.coderslab.book.entity.Book;
import pl.coderslab.book.repository.BookRepository;
import pl.coderslab.category.entity.Category;
import pl.coderslab.category.service.CategoryService;
import pl.coderslab.publisher.entity.Publisher;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookDao bookDao;
    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    public Book findById(long id) {
        return bookDao.findById(id);
    }

    public Book findWithAutorsById(long id) {
        return getAuthorsForBook(bookDao.findById(id));
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

    public List<Book> getBooksByTitle(String title) {
        return getAuthorsForBooks(bookRepository.findBooksByTitle(title));
    }

    public List<Book> getBooksByCategory(long id) throws NoSuchElementException {
        Category category = categoryService.findById(id).get();
        return getBooksByCategory(category);
    }
    public List<Book> getBooksByCategory(Category category) {
        return getAuthorsForBooks(bookRepository.findBooksByCategory(category));
    }

    public List<Book> getBooksByCategoryId(long id) {
        return getAuthorsForBooks(bookRepository.findBooksByCategoryId(id));
    }

    public List<Book> getBooksByCategoryName(String name) {
        return getAuthorsForBooks((bookRepository.findBooksByCategoryName(name)));
    }

    public List<Book> getBooksByAuthor(Author author) {
        return getAuthorsForBooks(bookRepository.findBooksByAuthors(author));
    }

    public List<Book> getBooksByPublisher(Publisher publisher) {
        return getAuthorsForBooks(bookRepository.findBooksByPublisher(publisher));
    }

    public List<Book> getBooksByRating(int rating) {
        return getAuthorsForBooks(bookRepository.findBooksByRating(rating));
    }

    public Book getFirstBookByCategoryOrderByTitle(Category category) {
        return getAuthorsForBook(bookRepository.getFirstBookByCategoryOrderByTitle(category));
    }

    public List<Book> manualFindBooksByTitle(String title) {
        return getAuthorsForBooks(bookRepository.manualFindBooksByTitle(title));
    }

    public List<Book> manualFindBooksByCategory(Category category) {
        return getAuthorsForBooks(bookRepository.manualFindBooksByCategory(category));
    }

    public List<Book> manualFindBooksByRatingRange(int min, int max) {
        return getAuthorsForBooks(bookRepository.manualFindBooksByRatingRange(min, max));
    }

    public Book manualFindFirstBookByCategoryId(long id) {
        return getAuthorsForBook(bookRepository.manualFindFirstBookByCategoryId(id));
    }

    private Book getAuthorsForBook(Book book) {
        if (book != null) {
            Hibernate.initialize(book.getAuthors());
        }
        return book;
    }

    private List<Book> getAuthorsForBooks(List<Book> books) {
        books.stream()
                .forEach(b -> getAuthorsForBook(b));
        return books;
    }
}
