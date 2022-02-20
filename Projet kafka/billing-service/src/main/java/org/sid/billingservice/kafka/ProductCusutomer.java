package org.sid.billingservice.kafka;

import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class ProductCusutomer {

    //////////////////////////////////////////////
    // Pour traiter un seul produit ou customer //
    //////////////////////////////////////////////

    @Bean
    public Consumer<Product> productConsumer(){
        return (product)->{
                System.out.println("---------------");
                System.out.println(product);
                System.out.println("----------------");
        };
    }

    @Bean
    public Consumer<Customer> customerConsumer(){
        return (customer)->{
            System.out.println("---------------");
            System.out.println(customer);
            System.out.println("----------------");
        };
    }

    //////////////////////////////////////////////////////
    // Pour traiter une liste des produits ou customers //
    //////////////////////////////////////////////////////

    @Bean
    public Consumer<List<Product>> productsConsumer(){
        return (products)->{
            for(Product p: products){
                System.out.println("---------------");
                System.out.println(p);
                System.out.println("----------------");
            }

        };
    }

    @Bean
    public Consumer<List<Customer>> customersConsumer(){
        return (customers)->{
            for(Customer c: customers){
                System.out.println("---------------");
                System.out.println(c);
                System.out.println("----------------");
            }

        };
    }

    /*@Bean
    public Consumer<Product> productConsumer(){
        System.out.println("Tessst");
        return (input)->{
            System.out.println("---------------");
            System.out.println(input.toString());
            System.out.println("----------------");
            System.out.println(input.getName());
        };
    }*/

   /* @Bean
    public Consumer<String> productConsumer(){
        System.out.println("Tessst");
        return (input)->{
            System.out.println("---------------");
            System.out.println(input);
            System.out.println("----------------");

        };
    }*/
}
