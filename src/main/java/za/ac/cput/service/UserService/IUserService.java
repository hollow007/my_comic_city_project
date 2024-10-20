package za.ac.cput.service.UserService;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.service.IService;

import java.util.List;

@Service
public interface IUserService extends IService<User, Long> {
    List<User> getAll();
}
