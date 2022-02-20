package org.sid.billingservice.web;


import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.feign.CustomerRestClient;
import org.sid.billingservice.feign.ProductItemRestClient;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.sid.billingservice.repositories.BillRepository;
import org.sid.billingservice.repositories.ProductItemRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BillingRestController {

    BillRepository billRepository;
    ProductItemRepository productItemRepository;
    CustomerRestClient customerRestClient;
    ProductItemRestClient productRestClient;

    public BillingRestController(BillRepository billRepository,
                                 ProductItemRepository productItemRepository,
                                 CustomerRestClient customerRestClient,
                                 ProductItemRestClient productRestClient)
    {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }


    @GetMapping(path = "/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id)
    {
        Bill bill = billRepository.findById(id).get();
        // Va chercher le CUSTOMER dans le Microservice customer-service qui correspand a cette facture
        Customer customer = customerRestClient.getCustomerById(bill.getCustomerID());// customer-service
        bill.setCustomer(customer);

        bill.getProductItems().forEach(productItem -> {
            Product product = productRestClient.getProductById(productItem.getProductID());
            productItem.setProductName(product.getName());
            productItem.setProduct(product);
        });

        return bill;
    }

}
