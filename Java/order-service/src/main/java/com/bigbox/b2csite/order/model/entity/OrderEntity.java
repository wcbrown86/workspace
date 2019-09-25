package com.bigbox.b2csite.order.model.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String orderNumber;
	
	@Column
	private String orderlabel;
	
	@Column
	private long customerId;
	
	@Column
	private long shippingAddressId;
	
	@Column
	private long billingAddressId;
	
	@Column
	private Date comletionDate;
	
	@OneToMany
	private List<OrderItemEntity> orderItemList = new LinkedList<OrderItemEntity>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderlabel() {
		return orderlabel;
	}

	public void setOrderlabel(String orderlabel) {
		this.orderlabel = orderlabel;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(long shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public long getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(long billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public Date getComletionDate() {
		return comletionDate;
	}

	public void setComletionDate(Date comletionDate) {
		this.comletionDate = comletionDate;
	}

	public List<OrderItemEntity> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItemEntity> orderItemList) {
		this.orderItemList = orderItemList;
	}
	

}
