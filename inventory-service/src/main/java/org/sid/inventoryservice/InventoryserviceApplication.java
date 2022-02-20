package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryserviceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
                productRepository.save(new Product(null, "Ordinateur",6000,12));
            productRepository.save(new Product(null, "Imprimante",5000,35));
            productRepository.save(new Product(null, "SmartPhone",3500,50));
            productRepository.findAll().forEach(p -> {
                System.out.println(p.toString());
            });

        };
    }
}
