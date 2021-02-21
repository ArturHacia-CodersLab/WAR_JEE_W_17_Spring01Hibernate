package pl.coderslab.category.converter;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.category.entity.Category;

import org.springframework.core.convert.converter.Converter;
import pl.coderslab.category.service.CategoryService;

public class CategoryConverter implements Converter<String, Category> {
    @Autowired
    private CategoryService categoryService;

    @Override
    public Category convert(String s) {
        return categoryService.findById(Long.parseLong(s)).orElse(null);
    }
}
