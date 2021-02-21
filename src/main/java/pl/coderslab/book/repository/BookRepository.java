package pl.coderslab.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.author.entity.Author;
import pl.coderslab.book.entity.Book;
import pl.coderslab.category.entity.Category;
import pl.coderslab.publisher.entity.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByTitle(String title);
    List<Book> findBooksByCategory(Category category);
    List<Book> findBooksByCategoryId(long categoryId);
    List<Book> findBooksByCategoryName(String categoryName);
    List<Book> findBooksByAuthors(Author author);
    List<Book> findBooksByPublisher(Publisher publisher);
    List<Book> findBooksByRating(int rating);
    Book getFirstBookByCategoryOrderByTitle(Category category);

    @Query("select b from Book b where b.title = ?1")
    List<Book> manualFindBooksByTitle(String title);

    @Query("select b from Book b where b.category = ?1")
    List<Book> manualFindBooksByCategory(Category category);

    @Query("select b from Book b where b.rating between ?1 and ?2")
    List<Book> manualFindBooksByRatingRange(int min, int max);

    @Query(nativeQuery = true, value = "select * from books where category_id = ?1 order by title limit 1")
    Book manualFindFirstBookByCategoryId(long id);
}
