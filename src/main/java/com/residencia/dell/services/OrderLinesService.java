package com.residencia.dell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.OrderLineId;
import com.residencia.dell.entities.OrderLines;
import com.residencia.dell.repositories.OrderLinesRepository;
import com.residencia.dell.repositories.OrderRepository;

@Service
public class OrderLinesService {

	@Autowired
	public OrderLinesRepository orderLinesRepository;
	public OrderRepository orderRepository;

	public OrderLines findById(OrderLineId orderlineId) {
		return orderLinesRepository.findById(orderlineId).get();

	}

	public List<OrderLines> findAll() {
		return orderLinesRepository.findAll();
	}

	public Long count() {
		return orderLinesRepository.count();
	}

	public OrderLines save(OrderLines orderLines) {
		OrderLines newOrderLine = orderLinesRepository.save(orderLines);
		return newOrderLine;
	}

	public OrderLines update(OrderLines orderLines, OrderLineId id) {
		orderLines.setOrderLinesId(id);
		return orderLinesRepository.save(orderLines);
	}

	public void deleteById(OrderLineId id) {
		orderLinesRepository.deleteById(id);
	}
}
