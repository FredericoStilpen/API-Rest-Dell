package com.residencia.dell.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Customers;
import com.residencia.dell.entities.Order;
import com.residencia.dell.entities.OrderLines;
import com.residencia.dell.exceptions.ResourceNotFoundException;
import com.residencia.dell.repositories.CustomersRepository;
import com.residencia.dell.repositories.OrderLinesRepository;
import com.residencia.dell.repositories.OrderRepository;
import com.residencia.dell.repositories.ProductsRepository;
import com.residencia.dell.vo.ItemOrderLinesVO;
import com.residencia.dell.vo.NotaFiscalVO;
import com.residencia.dell.vo.OrderLinesVO;
import com.residencia.dell.vo.OrdersVO;

@Service
public class OrderService {

	@Autowired
	public OrderRepository orderRepository;

	@Autowired
	public OrderLinesRepository orderLinesRepository;

	@Autowired
	public ProductsRepository productsRepository;

	@Autowired
	public CustomersRepository customersRepository;

	public Order findById(Integer id) {
		return orderRepository.findById(id).get();
	}

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public List<Order> findAll(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Order> listOrders = null;
		List<Order> listOrdersComPaginacao = null;

		try {
			if (null != pagina && null != qtdRegistros) {
				page = PageRequest.of(pagina, qtdRegistros);
				listOrdersComPaginacao = orderRepository.findAll(page).getContent();

				return listOrdersComPaginacao;
			} else {
				listOrders = orderRepository.findAll();

				return listOrders;
			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
		}
	}

	public List<OrdersVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Order> listOrders = null;
		List<Order> listOrdersComPaginacao = null;
		List<OrdersVO> listOrdersVO = new ArrayList<>();

		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listOrdersComPaginacao = orderRepository.findAll(page).getContent();

				for (Order lOrders : listOrdersComPaginacao) {
					listOrdersVO.add(convertEntidadeParaVO(lOrders));
				}

			} else {
				listOrders = orderRepository.findAll();

				for (Order lOrders : listOrders) {
					listOrdersVO.add(convertEntidadeParaVO(lOrders));
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
		}

		return listOrdersVO;
	}

	private OrdersVO convertEntidadeParaVO(Order orders) {
		OrdersVO ordersVO = new OrdersVO();

		ordersVO.setNetAmount(orders.getNetAmount());
		ordersVO.setOrderDate(orders.getOrderDate());
		ordersVO.setOrderId(orders.getOrderId());
		ordersVO.setTax(orders.getTax());
		ordersVO.setTotalAmount(orders.getTotalAmount());

		return ordersVO;
	}

	public Long count() {
		return orderRepository.count();
	}

	public Order save(Order orders) {
		Order newOrders = orderRepository.save(orders);
		return newOrders;
	}

	public void delete(Integer id) {
		orderRepository.deleteById(id);
	}

	public Order update(Integer id, Order orders) {
		Order newOrders = orderRepository.findById(id).get();
		updateDados(newOrders, orders);
		return orderRepository.save(newOrders);
	}

	private void updateDados(Order newOrders, Order order) {
		newOrders.setOrderDate(order.getOrderDate());
		newOrders.setCustomerId(order.getCustomerId());
		newOrders.setNetAmount(order.getNetAmount());
		newOrders.setTax(order.getTax());
		newOrders.setTotalAmount(order.getTotalAmount());
	}

	public NotaFiscalVO emitirNF(Integer orderId) {

		Order order = orderRepository.getById(orderId);

		List<OrderLines> listOrderLines = orderLinesRepository.findByOrders(order);

		NotaFiscalVO notaFiscalVO = new NotaFiscalVO();

		notaFiscalVO.setFirstname(order.getCustomerId().getFirstName());
		notaFiscalVO.setLastname(order.getCustomerId().getLastName());
		notaFiscalVO.setNetAmount(order.getNetAmount());
		notaFiscalVO.setOrderDate(order.getOrderDate());
		notaFiscalVO.setOrderId(order.getOrderId());
		notaFiscalVO.setTotalAmount(order.getTotalAmount());

		List<ItemOrderLinesVO> listItemOrderLinesVO = new ArrayList<>();

		for (OrderLines orderlines : listOrderLines) {
			ItemOrderLinesVO itemOrderLinesVO = new ItemOrderLinesVO();

			itemOrderLinesVO.setProdId(orderlines.getProdId());
			itemOrderLinesVO.setQuanttity(orderlines.getQuantity());
			itemOrderLinesVO.setTitle(productsRepository.findById(orderlines.getProdId()).get().getTitle());

			listItemOrderLinesVO.add(itemOrderLinesVO);
		}

		notaFiscalVO.setListItemOrderLinesVO(listItemOrderLinesVO);

		return notaFiscalVO;
	}

	public Order saveVO(OrdersVO ordersVO) {

		Order orders = new Order();

		Integer id = null;

		orders.setOrderId((null == id) ? ordersVO.getOrderId() : id);
		orders.setNetAmount(ordersVO.getNetAmount());
		orders.setOrderDate(ordersVO.getOrderDate());
		orders.setTax(ordersVO.getTax());
		orders.setTotalAmount(ordersVO.getTotalAmount());
		orders.setCustomerId(customersRepository.findById(ordersVO.getCustomer()).get());

		Order newOrders = orderRepository.save(orders);

		Integer contadorOrderlinesId = 1;

		for (OrderLinesVO itemOrderLinesVO : ordersVO.getListOrderLinesVO()) {
			OrderLines orderlines = new OrderLines(contadorOrderlinesId, newOrders.getOrderId(),
					productsRepository.getById(itemOrderLinesVO.getProdId()).getProdId(),
					itemOrderLinesVO.getQuantity(), itemOrderLinesVO.getOrderDate());

			orderLinesRepository.save(orderlines);

			contadorOrderlinesId++;
		}

		return newOrders;

	}

}
