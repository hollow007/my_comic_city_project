//package za.ac.cput.service.OrderService;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import za.ac.cput.domain.Order;
//import za.ac.cput.repository.OrderRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class OrderService {
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    public List<Order> getAllOrders() {
//        return orderRepository.findAll();
//    }
//
//    public Optional<Order> getOrderById(String id) {
//        return orderRepository.findById(id);
//    }
//
//    public Order saveOrder(Order order) {
//        return orderRepository.save(order);
//    }
//
//    public void deleteOrderById(String id) {
//        orderRepository.deleteById(id);
//    }
//}
//
