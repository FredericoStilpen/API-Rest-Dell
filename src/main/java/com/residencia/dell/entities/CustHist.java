package com.residencia.dell.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cust_hist")
public class CustHist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "orderid")
	private Integer orderId;

	@Column(name = "prod_id")
	private Integer prodId;

	@ManyToOne
	@JoinColumn(name = "customerid", referencedColumnName = "customerid")
	private Customers customerId;

	public Customers getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customers customerId) {
		this.customerId = customerId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

}
