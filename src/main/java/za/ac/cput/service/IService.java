package za.ac.cput.service;

/**
 * Mpumzi Mbula
 * 219053324
 * 19/05/2024
 *
 */
import org.springframework.stereotype.Service;

@Service
public interface IService <T, ID> {

    T create(T t);

    T read(ID id);

    T update(T t);
    boolean delete(ID id);

}