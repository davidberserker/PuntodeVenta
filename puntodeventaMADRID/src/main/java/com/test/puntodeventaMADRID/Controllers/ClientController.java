package com.test.puntodeventaMADRID.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.puntodeventaMADRID.JPA.ClientRepository;
import com.test.puntodeventaMADRID.Models.Client;


@RestController
//@RequestMapping (path = "/Client")

public class ClientController {

	
	private ClientRepository clientRepository;
	
	
	
	public ClientController(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}



	@GetMapping(path = "/clients")
	public List<Client> getAllClients(){
		List<Client> clients = clientRepository.findAll();
		return clients;
	}
	
	@GetMapping(path = "/clients/{id}")
	public Optional<Client> getClientById(@PathVariable int id){
		Optional<Client> client = clientRepository.findById(id);
		if(client.isEmpty()) {
			throw new ExceptionNotFound("*****************User not found**************");
		}
		return client;
	}
	
	@PostMapping("/clients")
	public ResponseEntity addUser(@Valid @RequestBody Client client) {
		
		clientRepository.save(client);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/users/{id}")
	public void updateUserByID(@PathVariable int id, @Valid @RequestBody Client client) {
		Optional<Client> clientInDb = clientRepository.findById(id);
		
		if(clientInDb.isEmpty()) {
			throw new ExceptionNotFound("user not found");
		}
		
		clientInDb.get().setName(client.getName());
	}
	
	
	@DeleteMapping("/user/{id}")
	public void deleteUserById(@PathVariable int id) {
		Optional<Client> clientInDb = clientRepository.findById(id);
		
		if(clientInDb.isEmpty()) {
			throw new ExceptionNotFound("user not found");
		}
		clientRepository.deleteById(id);
	}
	
}
