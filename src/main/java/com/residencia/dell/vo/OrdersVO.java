package com.residencia.dell.vo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class OrdersVO {

	private Integer quantity;
	private Calendar orderDate;
	private Integer orderId;
	private BigDecimal totalAmount;
	private BigDecimal tax;
	private BigDecimal netAmount;
	private List<OrderLinesVO> listOrderLinesVO;
	private Integer Customer;

	public Integer getCustomer() {
		return Customer;
	}

	public void setCustomer(Integer customer) {
		Customer = customer;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal bigDecimal) {
		this.totalAmount = bigDecimal;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public List<OrderLinesVO> getListOrderLinesVO() {
		return listOrderLinesVO;
	}

	public void setListOrderLinesVO(List<OrderLinesVO> listOrderLinesVO) {
		this.listOrderLinesVO = listOrderLinesVO;
	}

}