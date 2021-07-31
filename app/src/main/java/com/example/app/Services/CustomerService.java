package com.example.app.services;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import com.example.app.DTO.CustomerInput;
import com.example.app.DTO.CustomerPayload;
import com.example.app.entities.CustomerEntity;
import com.example.app.repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<CustomerPayload> getCustomers() {
        return repository
            .findAll()
            .stream()
            .map(todo -> new CustomerPayload(
                todo.getId(),
                todo.getName(),
                todo.getSurname(),
                todo.getCreated()
            ))
            .collect(Collectors.toList());
    }

    public CustomerPayload getCustomer(Long id) {
        CustomerEntity todo = repository
            .findById(id)
            .orElseThrow(() -> new IllegalStateException("todo with id: " + id + "does not exist"));
        return new CustomerPayload(
            todo.getId(),
            todo.getName(),
            todo.getSurname(),
            todo.getCreated());
    }

    public CustomerPayload addCustomer(CustomerInput input) {
        CustomerEntity todo = new CustomerEntity(input.name, input.surname);
        repository.save(todo);
        return new CustomerPayload(
                todo.getId(),
                todo.getName(),
                todo.getSurname(),
                todo.getCreated());
    }

    @Transactional
    public CustomerPayload updateCustomer(Long id, CustomerInput input) {
        CustomerEntity todo = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("todo with id: " + id + " does not exist"));
        if (input.name == null || input.name.equals("")) {
            throw new IllegalStateException("customer name could not be empty string");
        }
        if (input.surname == null || input.surname.equals("")) {
            throw new IllegalStateException("customer surname could not be empty string");
        }
        todo.setName(input.name);
        todo.setSurname(input.surname);
        repository.save(todo);
        return new CustomerPayload(
                todo.getId(),
                todo.getName(),
                todo.getSurname(),
                todo.getCreated());
    }

    public CustomerPayload removeCustomer(Long id) {
        CustomerEntity todo = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("customer with id: " + id + " does not exist"));
        repository.delete(todo);
        return new CustomerPayload(
                todo.getId(),
                todo.getName(),
                todo.getSurname(),
                todo.getCreated());
    }
}
