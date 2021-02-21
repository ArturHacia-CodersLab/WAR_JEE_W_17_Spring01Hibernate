package pl.coderslab.book.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.entity.Author;
import pl.coderslab.author.service.AuthorService;
import pl.coderslab.book.entity.Book;
import pl.coderslab.book.service.BookService;
import pl.coderslab.category.entity.Category;
import pl.coderslab.category.service.CategoryService;
import pl.coderslab.publisher.entity.Publisher;
import pl.coderslab.publisher.service.PublisherService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/book/form")
@RequiredArgsConstructor
public class BookFormController {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherService.getAllPublishers();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorService.getAllAutors();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/add")
    public String form(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/book/form";
    }

    @PostMapping("/add")
    public String save(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/book/form";
        }
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
    public String update(@PathVariable long id, @Valid Book book, BindingResult result) {
        if (book.getId() == id) {
            if (result.hasErrors()) {
                return "/book/form";
            }
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

    @GetMapping("/search/title/{title}")
    public String getBooksByTitle(@PathVariable String title, Model model) {
        model.addAttribute("books", bookService.getBooksByTitle(title));
        return "/book/list";
    }

    @GetMapping("/search/category/{id}")
    public String getBooksByCategory(@PathVariable long id, Model model) {
        try {
            model.addAttribute("books", bookService.getBooksByCategory(id));
        } catch (NoSuchElementException e) {
            model.addAttribute("message", "Nie ma kategorii o podanym id");
        }
        return "/book/list";
    }

    @GetMapping("/search/categoryid/{id}")
    public String getBooksByCategoryId(@PathVariable long id, Model model) {
        model.addAttribute("books", bookService.getBooksByCategoryId(id));
        return "/book/list";
    }

    @GetMapping("/search/categoryname/{name}")
    public String getBooksByCategoryName(@PathVariable String name, Model model) {
        model.addAttribute("books", bookService.getBooksByCategoryName(name));
        return "/book/list";
    }

    @GetMapping("/search/categoryobject/{category}")
    public String getBookByCategoryObject(@PathVariable Category category, Model model) {
        model.addAttribute("books", bookService.getBooksByCategory(category));
        return "book/list";
    }

    @GetMapping("/search/author/{author}")
    public String getBooksByAuthor(@PathVariable Author author, Model model) {
        model.addAttribute("books", bookService.getBooksByAuthor(author));
        return "/book/list";
    }

    @GetMapping("/search/publisher/{publisher}")
    public String getBooksByPublisher(@PathVariable Publisher publisher, Model model) {
        model.addAttribute("books", bookService.getBooksByPublisher(publisher));
        return "/book/list";
    }

    @GetMapping("/search/rating/{rating}")
    public String getBooksByRating(@PathVariable int rating, Model model) {
        model.addAttribute("books", bookService.getBooksByRating(rating));
        return ("/book/list");
    }

    @GetMapping("/search/firstbycategory/{category}")
    public String getFirstBookByCategoryOrderByTitle(@PathVariable Category category, Model model) {
        Book book = bookService.getFirstBookByCategoryOrderByTitle(category);
        if (book != null) {
            model.addAttribute("books", Arrays.asList(book));
        } else {
            model.addAttribute("message", "Nie znaleziono książki dla podanej kategorii");
        }

        return "/book/list";
    }

    @GetMapping("/manual/title/{title}")
    public String manualFindBooksByTitle(@PathVariable String title, Model model) {
        model.addAttribute("books", bookService.manualFindBooksByTitle(title));
        return "/book/list";
    }

    @GetMapping("/manual/category/{category}")
    public String manualFindBooksByCategory(@PathVariable Category category, Model model) {
        model.addAttribute("books", bookService.manualFindBooksByCategory(category));
        return "/book/list";
    }

    @GetMapping("/manual/rating/{min}/{max}")
    public String manualFindBooksByRatingRange(@PathVariable int min, @PathVariable int max, Model model) {
        model.addAttribute("books", bookService.manualFindBooksByRatingRange(min, max));
        return "/book/list";
    }

    @GetMapping("/manual/firstbycategory/{id}")
    public String manualFindFirstBookByCategryId(@PathVariable long id, Model model) {
        Book book = bookService.manualFindFirstBookByCategoryId(id);
        if (book != null) {
            model.addAttribute("books", Arrays.asList(book));
        } else {
            model.addAttribute("message", "Nie znaleziono książki dla zadanej kategorii");
        }
        return "/book/list";
    }
}
