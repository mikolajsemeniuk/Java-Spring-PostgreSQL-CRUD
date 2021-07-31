package com.example.app.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CustomerInput {
    @NotEmpty
	@Size(min = 4, message = "customer name should have at least 4 characters")
    public String name;
    @NotEmpty
	@Size(min = 4, message = "customer surname should have at least 4 characters")
    public String surname;
}
