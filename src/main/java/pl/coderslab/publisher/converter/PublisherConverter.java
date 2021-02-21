package pl.coderslab.publisher.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.publisher.entity.Publisher;
import pl.coderslab.publisher.service.PublisherService;

public class PublisherConverter  implements Converter<String, Publisher> {
    @Autowired
    private PublisherService publisherService;

    @Override
    public Publisher convert(String s) {
        return publisherService.findById(Long.parseLong(s));
    }
}
