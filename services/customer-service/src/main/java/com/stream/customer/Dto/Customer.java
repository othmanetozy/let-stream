package com.stream.customer.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class Customer {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private Adresse adresse;
}
