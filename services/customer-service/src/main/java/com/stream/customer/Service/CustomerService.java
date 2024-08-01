package com.stream.customer.Service;

import com.stream.customer.records.CustomerResponse;
import com.stream.customer.Dto.Customer;
import com.stream.customer.Exception.CustomerNotFoundException;
import com.stream.customer.Mapping.CustomerMapper;
import com.stream.customer.Repository.CustomerRepository;
import com.stream.customer.records.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public String createCustomer(CustomerRequest request) {
        var customer = customerRepository.save(customerMapper.toCustomer(request));
        return  customer.getId();
    }

    public void updateCustomer(CustomerRequest request) {
        var customer = customerRepository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update customer :: No customer found with ID %d", request.id())
                ));
        mergeCustomer(customer, request);
        customerRepository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstname(request.firstname());
        }
        if (StringUtils.isNotBlank(request.lastname())){
            customer.setFirstname(request.lastname());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.adresse() != null){
            customer.setAdresse(request.adresse());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public Boolean existById(String customerId) {
        return customerRepository.findById(customerId).isPresent();
    }

    public CustomerResponse findById(String customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::fromCustomer)
                .orElseThrow(()->new CustomerNotFoundException((format("No customer found with the provuded ID :: %s ",customerId))));
    }

    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }
}

