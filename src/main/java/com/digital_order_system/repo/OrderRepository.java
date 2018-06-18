package com.digital_order_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital_order_system.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
