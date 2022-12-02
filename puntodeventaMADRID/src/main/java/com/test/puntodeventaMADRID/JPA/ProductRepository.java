package com.test.puntodeventaMADRID.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.puntodeventaMADRID.Models.Client;
import com.test.puntodeventaMADRID.Models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
