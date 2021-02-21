package pl.coderslab.publisher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.publisher.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findFirstByNip(String nip);
    Publisher findFirstByRegon(String regon);
}
