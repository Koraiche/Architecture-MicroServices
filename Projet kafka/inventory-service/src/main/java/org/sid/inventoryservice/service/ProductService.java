package org.sid.inventoryservice.service;

import org.sid.inventoryservice.entities.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class ProductService {

    /*@Bean
    public Consumer<Product> productConsumer(){
        return (input)->{
            System.out.println("---------------");
            System.out.println(input.toString());
            System.out.println("----------------");
        };
    }*/
}
