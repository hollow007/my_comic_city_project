package za.ac.cput.service.adminService;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.service.IService;

import java.util.List;
@Service
public interface IAdminService extends IService<Admin,Long> {
    List<Admin> getAll();
}