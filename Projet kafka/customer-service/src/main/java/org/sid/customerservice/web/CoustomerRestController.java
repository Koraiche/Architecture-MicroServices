package org.sid.customerservice.web;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoustomerRestController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StreamBridge streamBridge;

    @GetMapping("/publier/{topic}")
    public List<Customer> publier(@PathVariable String topic){
        List<Customer> customers = customerRepository.findAll();
        streamBridge.send(topic,customers);
        return customers;
    }
}
