package com.example.demo.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {
@Id
private int productId;
private int productName;
private int productPrice;

@OneToMany(mappedBy="Product")
private List<Order>order;

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public int getProductName() {
	return productName; 
}

public void setProductName(int productName) {
	this.productName = productName;
}

public int getProductPrice() {
	return productPrice;
}

public void setProductPrice(int productPrice) {
	this.productPrice = productPrice;
}

public List<Order> getOrder() {
	return order;
}

public void setOrder(List<Order> order) {
	this.order = order;
}


}
