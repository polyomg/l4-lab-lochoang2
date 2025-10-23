package poly.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.category.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {}
