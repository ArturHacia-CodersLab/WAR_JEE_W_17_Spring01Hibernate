package pl.coderslab.book.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.author.entity.Author;
import pl.coderslab.book.entity.Book;
import pl.coderslab.publisher.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> getAllBooks() {
        Query query = entityManager.createQuery("select distinct b from Book b join fetch b.authors");
        return query.getResultList();
    }

    public List<Book> getRatingList(int rating) {
        Query query = entityManager.createQuery("select distinct b from Book b join fetch b.authors where b.rating = :rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }

    public List<Book> getBookWithPublisher() {
        Query query = entityManager.createQuery("select distinct b from Book b join fetch b.authors join b.publisher");
        return query.getResultList();
    }

    public List<Book> getBookWithPublisher(Publisher publisher) {
        Query query = entityManager.createQuery("select distinct b from Book b join fetch b.authors where b.publisher = :publisher");
        query.setParameter("publisher", publisher);
        return query.getResultList();
    }

    public List<Book> getBookWithAuthor(Author author) {
        Query query = entityManager.createQuery("select distinct b from Book b join fetch b.authors a where a = :author");
        query.setParameter("author", author);
        return query.getResultList();
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }
}
