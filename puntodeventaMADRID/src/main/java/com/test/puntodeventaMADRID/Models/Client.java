package com.test.puntodeventaMADRID.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity (name = "Client")

public class Client {
	
	@javax.persistence.Id
	@GeneratedValue
	private Integer Id;
	
	@Size (min=2, message = "The name must be greater than two characters ")
	private String Name;
	
	private Integer phone;
	
	public Client (){
		
	}

	public Client(Integer id, @Size(min = 2, message = "The name must be greater than two characters ") String name,
			Integer phone) {
		super();
		Id = id;
		Name = name;
		this.phone = phone;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
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
