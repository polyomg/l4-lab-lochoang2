package poly.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.category.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {}
