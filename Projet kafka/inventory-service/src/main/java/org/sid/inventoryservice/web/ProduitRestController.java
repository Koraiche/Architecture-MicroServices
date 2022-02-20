package org.sid.inventoryservice.web;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class ProduitRestController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StreamBridge streamBridge;

    @GetMapping("/publier/{topic}")
    public List<Product> publier(@PathVariable String topic){
        List<Product> p = productRepository.findAll();
        streamBridge.send(topic,p);
        return p;
    }
}
