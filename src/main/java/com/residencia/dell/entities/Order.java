package com.residencia.dell.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private Integer orderId;

	@Column(name = "orderdate")
	private Calendar orderDate;

	@ManyToOne
	@JoinColumn(name = "customerid", referencedColumnName = "customerid")
	private Customers customerId;

	@OneToMany(mappedBy = "orders")
	@JsonManagedReference
	private List<OrderLines> listOrderLines;

	@Column(name = "netamount")
	private BigDecimal netAmount;

	@DecimalMax(value = "10000", inclusive = false, message = "Não pode ser superior a 10.000")
	@Digits(integer = 5, fraction = 2, message = "Não pode ser superior a 10.000")
	@Column(name = "tax")
	private BigDecimal tax;

	@Column(name = "totalamount")
	private BigDecimal totalAmount;

	public Integer getOrderId() {
		return orderId;
	}

	public Customers getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customers customerId) {
		this.customerId = customerId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netamount) {
		this.netAmount = netamount;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<OrderLines> getListOrderLines() {
		return listOrderLines;
	}

	public void setListOrderLines(List<OrderLines> listOrderLines) {
		this.listOrderLines = listOrderLines;
	}

}
