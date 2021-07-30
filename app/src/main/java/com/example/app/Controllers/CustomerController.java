package com.example.app.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    @GetMapping
	public String getCustomers() {
		return "Greetings from Spring Boot!";
	}
    
    @GetMapping("/{id}")
    public String getCustomer(@PathVariable("id") Long id) {
        return "get method " + id;
    }

    @PostMapping
    public String addCustomer() {
        return "post method ";
    }

    @PutMapping("/{id}")
    public String updateCustomer() {
        return "put method ";
    }

    @DeleteMapping("/{id}")
    public String removeCustomer() {
        return "delete method";
    }
}
