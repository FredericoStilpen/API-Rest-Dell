package com.residencia.dell.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.dell.entities.OrderLineId;
import com.residencia.dell.entities.OrderLines;
import com.residencia.dell.repositories.OrderLinesRepository;
import com.residencia.dell.services.OrderLinesService;

@RestController
@RequestMapping("/orderlines")
public class OrderLinesController {

	@Autowired
	public OrderLinesService orderLinesService;
	public OrderLinesRepository orderLineRepository;

	@GetMapping("/{id}")
	public ResponseEntity<OrderLines> findById(@PathVariable OrderLineId id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(orderLinesService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/listar-todos")
	public ResponseEntity<List<OrderLines>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(orderLinesService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long count() {
		return orderLinesService.count();
	}

	@PostMapping
	public ResponseEntity<OrderLines> save(@RequestBody OrderLines orderLine) {

		HttpHeaders headers = new HttpHeaders();

		OrderLines newOrderLine = orderLinesService.save(orderLine);

		if (null != newOrderLine)
			return new ResponseEntity<>(newOrderLine, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(newOrderLine, headers, HttpStatus.BAD_REQUEST);
	}

	@PutMapping
	public OrderLines update(OrderLines orderLine, OrderLineId id) {
		return orderLinesService.update(orderLine, id);
	}

	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable OrderLineId id) {
		orderLinesService.deleteById(id);
	}

}
