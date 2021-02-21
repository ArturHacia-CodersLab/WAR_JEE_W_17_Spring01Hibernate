package pl.coderslab.book.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.book.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class ValidationController {
    private final Validator validator;

    @RequestMapping("/validate")
    @ResponseBody
    public String validate() {
        Book book = new Book();
        Set<ConstraintViolation<Book>> errors = validator.validate(book);
        if (!errors.isEmpty()) {
            for (ConstraintViolation<Book> error : errors) {
                System.out.println(error.getPropertyPath() + " : " + error.getMessage());
            }
            return "Walidacja nie poprawna";
        } else {
            return "Walidacja poprawna";
        }
    }

    @RequestMapping("/validateWithView")
    public String validateWithView(Model model) {
        Book book = new Book();
        model.addAttribute("errors", validator.validate(book));
        return "/validate/validate";
    }
}
