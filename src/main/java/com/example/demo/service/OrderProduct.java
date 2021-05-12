package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Order;
import com.example.demo.Models.Product;
import com.example.demo.repositary.OrderRepositary;
import com.example.demo.repositary.ProductRepositary;

@Service
public class OrderProduct {

	@Autowired
	private OrderRepositary Ooder;
	
	@Autowired
	private ProductRepositary Pprdct;
	
	
	public Order createorder( Order order) {
		return Ooder.save(order);
	}
	public Product createproduct(Product product) {
		return Pprdct.save(product);
	}
	
	public Iterable<Order>getOrders() {
		return Ooder.findAll();
	}
	public Iterable<Product>getProducts() {
		return Pprdct.findAll();
	}
	public Optional<Order>getOrder(Integer orderid) {
		return Ooder.findById(orderid);
	}
	public Optional<Product>getProduct(Integer productId) {
		return Pprdct.findById(productId);
	}
	public int placeOrder(Integer productId,Integer quantity,Order order) {
		int result =1;
		Product product = Pprdct.findById(productId).orElse(new Product());
		if(product==null)
		return result;
		order.setQuantity(quantity);
		order.setProduct(product);
		Ooder.save(order);
		result = 0;
		return result;
	}
	
	public int updateOrder(Integer id,Integer quantity) {
		int result = 1;
		Order order = Ooder.findById(id).orElse(new Order());
		if(order.getOrderid()==0){
			return result;	
		}
		order.setQuantity(quantity);
		Ooder.save(order);
		return result;
		
	}
}
