package pl.coderslab.publisher.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.publisher.dao.PublisherDao;
import pl.coderslab.publisher.entity.Publisher;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherDao publisherDao;

    public void savePublisher(Publisher publisher) {
        publisherDao.savePublisher(publisher);
    }

    public Publisher findById(long id) {
        return publisherDao.findById(id);
    }

    public List<Publisher> getAllPublishers() {
        return publisherDao.getAllPublishers();
    }

    public void update(Publisher publisher) {
        publisherDao.update(publisher);
    }

    public void delete(long id) {
        Publisher publisher = findById(id);
        publisherDao.delete(publisher);
    }
}
