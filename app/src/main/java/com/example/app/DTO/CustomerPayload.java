package com.example.app.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerPayload {
    public Long id;
    public String name;
    public String surname;
    public LocalDateTime created;
}
