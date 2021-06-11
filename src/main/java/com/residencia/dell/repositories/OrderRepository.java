package com.residencia.dell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.dell.entities.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
}
