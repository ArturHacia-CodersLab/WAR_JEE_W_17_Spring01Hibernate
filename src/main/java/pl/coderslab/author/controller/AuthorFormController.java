package pl.coderslab.author.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.author.entity.Author;
import pl.coderslab.author.service.AuthorService;

@Controller
@RequestMapping("/author/form")
@RequiredArgsConstructor
public class AuthorFormController {
    private final AuthorService authorService;

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("authors", authorService.getAllAutors());
        return "author/list";
    }

    @GetMapping("/add")
    public String form(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "/author/form";
    }

    @PostMapping("/add")
    public String save(Author author) {
        authorService.saveAuthor(author);
        return "redirect:/author/form/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("author", authorService.findById(id));
        return "/author/form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable long id, Author author) {
        if (author.getId() == id) {
            authorService.update(author);
        }
        return "redirect:/author/form/all";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "/author/confirm";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        authorService.delete(id);
        return "redirect:/author/form/all";
    }
}
