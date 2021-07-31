package com.example.app.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CustomerInput {
    @NotEmpty
	@Size(min = 4, message = "user name should have at least 2 characters")
    public String name;
    public String surname;
}
