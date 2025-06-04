package id.zar.shipping.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import id.zar.shipping.entities.Order;

// @Service
public interface OrderRepository extends JpaRepository<Order, UUID>{
    
}
