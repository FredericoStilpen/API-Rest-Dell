package com.residencia.dell.entities;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reorder")
public class Reorder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	private Integer prodId; // verificar ID.

	@Column(name = "reorder")
	private Calendar reorder;

	@Column(name = "quan_low")
	private Integer quanLow;

	@Column(name = "date_reordered")
	private Calendar dateReordered;

	@Column(name = "quan_reordered")
	private Integer quanReordered;

	@Column(name = "date_expected")
	private Calendar dateExpected;

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public Calendar getReorder() {
		return reorder;
	}

	public void setReorder(Calendar reorder) {
		this.reorder = reorder;
	}

	public Integer getQuanLow() {
		return quanLow;
	}

	public void setQuanLow(Integer quanLow) {
		this.quanLow = quanLow;
	}

	public Calendar getDateReordered() {
		return dateReordered;
	}

	public void setDateReordered(Calendar dateReordered) {
		this.dateReordered = dateReordered;
	}

	public Integer getQuanReordered() {
		return quanReordered;
	}

	public void setQuanReordered(Integer quanReordered) {
		this.quanReordered = quanReordered;
	}

	public Calendar getDateExpected() {
		return dateExpected;
	}

	public void setDateExpected(Calendar dateExpected) {
		this.dateExpected = dateExpected;
	}

}
