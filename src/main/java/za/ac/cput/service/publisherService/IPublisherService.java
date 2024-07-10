package za.ac.cput.service.publisherService;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Publisher;
import za.ac.cput.service.IService;

import java.util.List;

public interface IPublisherService extends IService<Publisher, Long> {
    List<Publisher> getall();
}
