package pl.coderslab.book.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.entity.Author;
import pl.coderslab.author.service.AuthorService;
import pl.coderslab.book.entity.Book;
import pl.coderslab.book.service.BookService;
import pl.coderslab.publisher.entity.Publisher;
import pl.coderslab.publisher.service.PublisherService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @RequestMapping("/all")
    @ResponseBody
    public String getAllBooks() {
        return bookService.getAllBooks().toString();
    }

    @RequestMapping("/all/rating/{rating}")
    @ResponseBody
    public String getRatingList(@PathVariable int rating) {
        return bookService.getRatingList(rating).toString();
    }

    @RequestMapping("/all/publisher")
    @ResponseBody
    public String getBookWithPublisher() {
        return bookService.getBookWithPublisher().toString();
    }

    @RequestMapping("/all/publisher/{id}")
    @ResponseBody
    public String getBookWithPublisher(@PathVariable int id) {
        Publisher publisher = publisherService.findById(id);
        if (publisher == null) {
            return "Nie ma takiego wydawcy";
        }
        return bookService.getBookWithPublisher(publisher).toString();
    }

    @RequestMapping("/all/author/{id}")
    @ResponseBody
    public String getBookWithAuthor(@PathVariable int id) {
        Author author = authorService.findById(id);
        if (author == null) {
            return "Nie ma takiego autora";
        }
        return bookService.getBookWithAuthor(author).toString();
    }

    @RequestMapping("/add")
    @ResponseBody
    public String hello() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setRating(12);
        book.setDescription("Podstawowa książka o nauce programowania");

        Publisher publisher = new Publisher();
        publisher.setName("PWN");
        publisherService.savePublisher(publisher);
        book.setPublisher(publisher);

        List<Author> authors = new ArrayList<>();
        authors.add(authorService.findById(1));
        authors.add(authorService.findById(2));
        book.setAuthors(authors);

        bookService.saveBook(book);
        return "Id dodanej książki to: " + book.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookService.findWithAutorsById(id);
        return book.toString();
    }

    @RequestMapping("/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title ) {
        Book book = bookService.findById(id);
        book.setTitle(title);
        bookService.update(book);
        return book.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        bookService.delete(id);
        return "deleted";
    }
}
