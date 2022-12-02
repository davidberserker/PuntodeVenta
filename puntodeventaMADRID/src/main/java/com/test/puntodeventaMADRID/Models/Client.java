package com.test.puntodeventaMADRID.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity (name = "Client")

public class Client {
	
	@javax.persistence.Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer clientId;
	
	@Size (min=2, message = "The name must be greater than two characters ")
	private String Name;
	
	private Integer phone;
	
	public Client (){
		
	}

	public Client(Integer clientId, String name, Integer phone) {
		super();
		this.clientId = clientId;
		Name = name;
		this.phone = phone;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	
	

}
