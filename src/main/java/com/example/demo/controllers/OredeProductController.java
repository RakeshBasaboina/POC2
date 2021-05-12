package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Message;
import com.example.demo.Models.Order;
import com.example.demo.Models.Product;
import com.example.demo.service.OrderProduct;

@RestController
@RequestMapping("/rest")
public class OredeProductController {

	@Autowired
	OrderProduct orderproduct;
	
	@PostMapping("/product/create")
	public Product createproduct(@RequestBody Product product) {
		return orderproduct.createproduct(product);
	}
	@GetMapping("product/list")
	public Iterable<Product>getProduct() {
		return orderproduct.getProducts();
	}
	@PostMapping("order/create")
	public Order createOrder(@RequestBody Order order) {
		return orderproduct.createorder(order);
	}
	@GetMapping("order/list")
	public Iterable<Order>getOrder() {
		return orderproduct.getOrders();
	}
	@GetMapping
	public Optional<Product>getProduct(@RequestParam("Id")Integer id) {
		return orderproduct.getProduct(id);
	}
	@GetMapping
	public Optional<Order>getOrder(@RequestParam("Id")Integer id) {
		return orderproduct.getOrder(id);
	}
	@GetMapping("/order/place")
	public Message placeOrder(@RequestParam("product_id") Integer id, @RequestParam("quantity") Integer quantity) {
		Message msg = getMsgObj();
		try {
			Order order = new Order();
			int code = orderproduct.placeOrder(id, quantity, order);
			if(code == 0) {
				msg.setCode(0);
				msg.setMessagr("Success");
			}
			else if(code == 1) {
				msg.setCode(1);
				msg.setMessagr("Invalid");
			}
			return msg;
		} catch (Exception e) {
			return msg;
		}
	}
	@GetMapping("/order/update")
	public Message updateOrder(@RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {
		Message msg = getMsgObj();
		try {
			int code = orderproduct.updateOrder(id, quantity);
			if(code == 0) {
				msg.setCode(0);
				msg.setMessagr("Success");
			}
			else if(code == 1) {
				msg.setCode(1);
				msg.setMessagr("Invalid");
			}
			return msg;
		} catch (Exception e) {
			return msg;
		}
	}
	private Message getMsgObj() {
		
		return null;
	}
}
