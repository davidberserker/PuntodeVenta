package com.test.puntodeventaMADRID.Models;

import java.time.LocalDate;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Order {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Integer orderId;
	private LocalDate creationDate;
	
	private int orderStatus;
	
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clientId")
	private Client client;
	
	public Order() {
		
	}

	public Order(Integer orderId, LocalDate creationDate, int orderStatus, @NotNull Client client) {
		super();
		this.orderId = orderId;
		this.creationDate = creationDate;
		this.orderStatus = orderStatus;
		this.client = client;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
