package com.test.puntodeventaMADRID.Models;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ProductOrder {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Integer productOrderId;
	public float totalPrice;
	private int quantity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "orderId")
	private Order order;
	
	//@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productId")
	private Product product;

public ProductOrder() {
	
}

public ProductOrder(Integer productOrderId, float totalPrice, int quantity, Order order, Product product) {
	super();
	this.productOrderId = productOrderId;
	this.totalPrice = totalPrice;
	this.quantity = quantity;
	this.order = order;
	this.product = product;
}

public Integer getProductOrderId() {
	return productOrderId;
}

public void setProductOrderId(Integer productOrderId) {
	this.productOrderId = productOrderId;
}

public float getTotalPrice() {
	return totalPrice;
}

public void setTotalPrice(float totalPrice) {
	this.totalPrice = totalPrice;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public Order getOrder() {
	return order;
}

public void setOrder(Order order) {
	this.order = order;
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}


}
