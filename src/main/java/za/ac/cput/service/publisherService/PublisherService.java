package za.ac.cput.service.publisherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Publisher;
import za.ac.cput.repository.PublisherRepository;

import java.util.List;
import java.util.Objects;
@Service
public class PublisherService implements IPublisherService{
    @Autowired
    private PublisherRepository repository;

    @Override
    public Publisher create(Publisher publisher) {
        return repository.save(publisher);
    }

    @Override
    public Publisher read(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }


    @Override
    public Publisher update(Publisher publisher) {
        return repository.save(publisher);
    }

    @Override
    public boolean delete(Long aLong) {
        repository.deleteById(aLong);
        return !repository.existsById(aLong);
    }

    @Override
    public List<Publisher> getall() {
        return repository.findAll();
    }
}
