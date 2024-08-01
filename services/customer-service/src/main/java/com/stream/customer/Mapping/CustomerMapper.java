package com.stream.customer.Mapping;

import com.stream.customer.records.CustomerResponse;
import com.stream.customer.Dto.Customer;
import com.stream.customer.records.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        if (request == null){
            return null;
        }
        return Customer.builder()
                .id(request.id())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .adresse(request.adresse())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getLastname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAdresse()
        );
    }
}
