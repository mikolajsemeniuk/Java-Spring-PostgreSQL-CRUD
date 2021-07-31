package com.example.app.Controllers;

import com.example.app.DTO.CustomerInput;
import com.example.app.DTO.CustomerPayload;
import com.example.app.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/customer")
public class CustomerController {
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CustomerPayload>> getCustomers() {
        return new ResponseEntity<List<CustomerPayload>>(service.getCustomers(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<CustomerPayload> getCustomer(@PathVariable("id") Long id) {
        return new ResponseEntity<CustomerPayload>(service.getCustomer(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerPayload> addCustomer(@Valid @RequestBody CustomerInput input) {
        return new ResponseEntity<CustomerPayload>(service.addCustomer(input), HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<CustomerPayload> updateCustomer(@PathVariable("id") Long id, @Valid @RequestBody CustomerInput input) {
        return new ResponseEntity<CustomerPayload>(service.updateCustomer(id, input), HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<CustomerPayload> removeCustomer(@PathVariable("id") Long id) {
        return new ResponseEntity<CustomerPayload>(service.removeCustomer(id), HttpStatus.OK);
    }
}
