package com.sb.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.rest.pojo.User;
import com.sb.rest.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	ClientService clientService;

	@GetMapping("/users")
	public Object getUsers() {
		return clientService.getUsers();
	}

	@PostMapping("/create")
	public String createUser(@RequestBody User user) {
		return clientService.createStudent(user);
	}
}
