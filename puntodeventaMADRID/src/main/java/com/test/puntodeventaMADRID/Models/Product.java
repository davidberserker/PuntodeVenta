package com.test.puntodeventaMADRID.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "Product")
public class Product {

		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		public Integer productId;
		private float unitPrice;
		private String productName;
		
		
		public Product() {
			
		}


		public Product(Integer productId, float unitPrice, String productName) {
			super();
			this.productId = productId;
			this.unitPrice = unitPrice;
			this.productName = productName;
		}


		public Integer getProductId() {
			return productId;
		}


		public void setProductId(Integer productId) {
			this.productId = productId;
		}


		public float getUnitPrice() {
			return unitPrice;
		}


		public void setUnitPrice(float unitPrice) {
			this.unitPrice = unitPrice;
		}


		public String getProductName() {
			return productName;
		}


		public void setProductName(String partName) {
			this.productName = partName;
		}
		
}
