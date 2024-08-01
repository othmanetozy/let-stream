package com.stream.customer.Repository;

import com.stream.customer.Dto.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,String> {
}
