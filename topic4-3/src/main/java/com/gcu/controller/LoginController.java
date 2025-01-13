package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

import jakarta.validation.Valid;

/**
 * Test
 */
@Controller
@RequestMapping("/login")
public class LoginController 
{
	@Autowired
	OrdersBusinessInterface service;
	
	@Autowired
	SecurityBusinessService security;
	
	@GetMapping("/")
	public String display(Model model) 
	{	
		// Display Login Form View
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) 
	{
		// Print the form values out
		System.out.println(String.format("Form with Username of %s and Password of %s", loginModel.getUsername(), loginModel.getPassword()));
		
		// Check for validation errors
		if(bindingResult.hasErrors()) 
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		// Retrieve orders from the service
		List<OrderModel> orders = service.getOrders();
		
		// Display the Orders View
		model.addAttribute("title", "My Order");
		model.addAttribute("orders", orders);
		
		service.test();
		security.authenticate("Bottle", "1234");
		return "orders";
	}
}
