package pl.coderslab.author.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.author.entity.Author;
import pl.coderslab.author.service.AuthorService;

public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorService authorService;

    @Override
    public Author convert(String s) {
        return authorService.findById(Long.parseLong(s));
    }
}
