package pl.coderslab.book.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.entity.Author;
import pl.coderslab.author.service.AuthorService;
import pl.coderslab.book.entity.Book;
import pl.coderslab.book.service.BookService;
import pl.coderslab.publisher.entity.Publisher;
import pl.coderslab.publisher.service.PublisherService;

import java.util.List;

@Controller
@RequestMapping("/book/form")
@RequiredArgsConstructor
public class BookFormController {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherService.getAllPublishers();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorService.getAllAutors();
    }

    @GetMapping("/add")
    public String form(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/book/form";
    }

    @PostMapping("/add")
    public String save(Book book) {
        bookService.saveBook(book);
        return "redirect:/book/form/all";
    }

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "/book/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("book", bookService.findWithAutorsById(id));
        return "/book/form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable long id, Book book) {
        if (book.getId() == id) {
            bookService.update(book);
        }
        return "redirect:/book/form/all";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "/book/confirm";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        bookService.delete(id);
        return "redirect:/book/form/all";
    }
}
