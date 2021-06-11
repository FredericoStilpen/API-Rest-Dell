package com.residencia.dell.controllers;

import java.util.List;
import javax.validation.Valid;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.residencia.dell.entities.Order;
import com.residencia.dell.exceptions.ResourceNotFoundException;
import com.residencia.dell.services.OrderService;
import com.residencia.dell.vo.NotaFiscalVO;
import com.residencia.dell.vo.OrdersVO;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	public OrderService orderService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Order> findById(@Valid @PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		Order order = orderService.findById(id);

		if (order == null) {
			throw new ResourceNotFoundException("Order Not Found for ID: " + id);
			// throw new ResourceNotFoundException.notFound().build();
		} else {
			return new ResponseEntity<>(orderService.findById(id), headers, HttpStatus.OK);
		} // throw new ResourceNotFoundException("Order Not Found " + id);
	}

	@GetMapping("/NF/{id}")
	public ResponseEntity<NotaFiscalVO> emitirNF(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(orderService.emitirNF(id), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Order>> findAll(@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) throws Exception {

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(orderService.findAll(pagina, qtdRegistros), headers, HttpStatus.OK);
	}

	@GetMapping("/listar-todos")
	public ResponseEntity<List<OrdersVO>> findAllVO(@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) throws Exception {

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(orderService.findAllVO(pagina, qtdRegistros), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long count() {
		return orderService.count();
	}

	@PostMapping
	public ResponseEntity<Order> saveVO(@Valid @RequestBody OrdersVO order) {

		HttpHeaders headers = new HttpHeaders();

		Order newOrder = orderService.saveVO(order);

		if (null != newOrder)
			return new ResponseEntity<>(newOrder, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(newOrder, headers, HttpStatus.BAD_REQUEST);

	}
	
//	@PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<String> saveVO(@Valid @RequestBody OrdersVO order){
//
//        Order newOrder = orderService.saveVO(order);
//        if(null != newOrder)
//            return ResponseEntity.ok("Order válido e salvo.");
//        else{
//            return ResponseEntity.unprocessableEntity().build();
//        }
//    }

	@PutMapping
	public Order update(Order order, Integer id) {
		return orderService.update(id, order);
	}

	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable Integer id) {
		orderService.delete(id);
	}
}
