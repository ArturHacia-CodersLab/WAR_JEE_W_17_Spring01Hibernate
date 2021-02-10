package pl.coderslab.publisher.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.publisher.entity.Publisher;
import pl.coderslab.publisher.service.PublisherService;

@Controller
@RequestMapping("/publisher/form")
@RequiredArgsConstructor
public class PublisherFormController {
    private final PublisherService publisherService;

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("publishers", publisherService.getAllPublishers());
        return "/publisher/list";
    }

    @GetMapping("/add")
    public String form(Model model) {
        Publisher publisher = new Publisher();
        model.addAttribute("publisher", publisher);
        return "/publisher/form";
    }

    @PostMapping("/add")
    public String save(Publisher publisher) {
        publisherService.savePublisher(publisher);
        return "redirect:/publisher/form/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("publisher", publisherService.findById(id));
        return "/publisher/form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable long id, Publisher publisher) {
        if (publisher.getId() == id) {
            publisherService.update(publisher);
        }
        return "redirect:/publisher/form/all";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "/publisher/confirm";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        publisherService.delete(id);
        return "redirect:/publisher/form/all";
    }
}
