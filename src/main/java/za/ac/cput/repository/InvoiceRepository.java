package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Invoice;
/* InvoiceRepository.java
   Author: Cavan Ramone Swartz (221055835)
   Date: 6 August 2024
   https://github.com/hollow007/my_comic_city_project
 */

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
   // boolean existsByOrderId(String orderId);
}
