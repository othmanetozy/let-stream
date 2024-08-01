package com.stream.customer.records;

import com.stream.customer.Dto.Adresse;


public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Adresse adresse
) {
}
