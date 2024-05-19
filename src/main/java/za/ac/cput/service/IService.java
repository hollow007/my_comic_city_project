package za.ac.cput.service;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project
import org.springframework.stereotype.Service;

@Service
public interface IService <T, ID> {

    T create(T t);

    T read(ID id);

    T update(T t);
    boolean delete(ID id);

}