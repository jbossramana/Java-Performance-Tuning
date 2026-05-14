package demo.boot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import demo.boot.entity.Order;

public interface OrderRepository
        extends JpaRepository<Order, Long> {
}
