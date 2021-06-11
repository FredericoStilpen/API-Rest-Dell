package com.residencia.dell.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.dell.entities.Order;
import com.residencia.dell.entities.OrderLineId;
import com.residencia.dell.entities.OrderLines;

@Repository
public interface OrderLinesRepository extends JpaRepository<OrderLines, OrderLineId> {

	List<OrderLines> findByOrders(Order orders);
	
}
