package pl.coderslab.category.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.category.entity.Category;
import pl.coderslab.category.service.CategoryService;

import javax.validation.Valid;

@Controller
@RequestMapping("/category/form")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @RequestMapping("/all")
    public String getAll(Model model) {
        model .addAttribute("categories", categoryService.getAll());
        return "/category/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("category", new Category());
        return "/category/form";
    }

    @PostMapping("/add")
    public String create(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "/category/form";
        }
        categoryService.save(category);
        return "redirect:/category/form/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("category", categoryService.findById(id).get());
        return "/category/form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable long id, @Valid Category category, BindingResult result) {
        if (category.getId() == id) {
            if (result.hasErrors()) {
                return "/category/form";
            }
            categoryService.save(category);
        }
        return "redirect:/category/form/all";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "/category/confirm";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        categoryService.delete(id);
        return "redirect:/category/form/all";
    }
}
