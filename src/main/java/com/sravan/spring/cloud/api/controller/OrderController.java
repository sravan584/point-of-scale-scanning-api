package com.sravan.spring.cloud.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sravan.spring.cloud.api.service.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@GetMapping("/{order}")
	public ResponseEntity<String> showPage(@PathVariable String order) {
		
		return ResponseEntity.ok("Total price of order is: "+orderService.getOrderPrice(order));
	}

}