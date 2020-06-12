package com.nagarro.msa.orders.orderrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.msa.orders.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query(value = "SELECT * FROM orders o WHERE o.user_id = ?1", nativeQuery = true)
	List<Order> findOrdersByUserId(Integer userId);

}
