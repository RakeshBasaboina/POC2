package com.example.demo.Models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Order {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int orderid;
	@ManyToOne
	private Product product;
	private int quantity;
	@CreationTimestamp
	private LocalDateTime ordertime;
	@UpdateTimestamp
	private LocalDateTime lastmodified;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDateTime getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(LocalDateTime ordertime) {
		this.ordertime = ordertime;
	}
	public LocalDateTime getLastmodified() {
		return lastmodified;
	}
	public void setLastmodified(LocalDateTime lastmodified) {
		this.lastmodified = lastmodified;
	}
	
	

}
