package pl.coderslab.author.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.author.entity.Author;
import pl.coderslab.author.service.AuthorService;

import javax.validation.Valid;

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
    public String save(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "/author/form";
        }
        authorService.saveAuthor(author);
        return "redirect:/author/form/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("author", authorService.findById(id));
        return "/author/form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable long id, @Valid Author author, BindingResult result) {
        if (author.getId() == id) {
            if (result.hasErrors()) {
                return "/author/form";
            }
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

    @GetMapping("/manual/email/{email}")
    public String findAuthorsByEmailBegin(@PathVariable String email, Model model) {
        model.addAttribute("authors", authorService.findAuthorsByEmailBegin(email));
        return "/author/list";
    }

    @GetMapping("/manual/pesel/{pesel}")
    public String findAuthorsByPeselBegin(@PathVariable String pesel, Model model) {
        model.addAttribute("authors", authorService.findAuthorsByPeselBegin(pesel));
        return "/author/list";
    }
}
