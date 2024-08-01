package com.stream.customer.records;

import com.stream.customer.Dto.Adresse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(String id, @NotNull(message="Firstname is required") String firstname, @NotNull(message="Lastname is required") String lastname,
                              @NotNull(message="Email is required") String email,
                              @Email(message = "Customer email is not valid email address")
                              Adresse adresse) {

}
