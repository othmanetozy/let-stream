package com.stream.customer.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Builder
public class Adresse {
    private String street;
    private String houseNumber;
    private String  zipCode;
}
