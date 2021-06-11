package com.residencia.dell.vo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class NotaFiscalVO {

	private String firstname;
	private String lastname;
	private BigDecimal netAmount;
	private Integer orderId;
	private Calendar orderDate;
	private BigDecimal totalAmount;
	private List<ItemOrderLinesVO> listItemOrderLinesVO;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<ItemOrderLinesVO> getListItemOrderLinesVO() {
		return listItemOrderLinesVO;
	}

	public void setListItemOrderLinesVO(List<ItemOrderLinesVO> listItemOrderLinesVO) {
		this.listItemOrderLinesVO = listItemOrderLinesVO;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

}
