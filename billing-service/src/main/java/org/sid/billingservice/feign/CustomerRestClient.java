package org.sid.billingservice.feign;


import org.sid.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping(path ="/customers/{id}")
    Customer getCustomerById(@PathVariable(name="id") Long id);

    @GetMapping(path = "/customers")
    Collection<Customer> getCustomers();
}
