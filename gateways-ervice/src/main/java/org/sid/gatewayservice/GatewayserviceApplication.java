package org.sid.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class GatewayserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserviceApplication.class, args);
    }
    /*
        Dans cette configuration statique on ne profite pas du load-balancer
    */
    /*
    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route((r)->r.path("/customers/**").uri("http://localhost:8080/"))
                .route((r)->r.path("/products/**").uri("http://localhost:8081/"))
                .build();
    }*/
    /* Methode statique 2 */
    //@Bean //desactiver le BEAN pour tester la methode dynamique
    RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route((r) -> r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
                .route((r) -> r.path("/products/**").uri("lb://INVENTORY-SERVICE"))
                .build();
    }
    /* Méthode dynamique : ici on dit a spring cloud gateway que nous enfete on ne connait pas les routes,
    * mais a chaque fois que TU recoit une requete, regarde dans le corps de la requete et tu va trouver
    * le nom du microService, en utilisant ce nom eureka va te fournir l'@ et le port pour que tu y accede */
    @Bean
    DiscoveryClientRouteDefinitionLocator definitionLocator(
            ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){
        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
    }
}
