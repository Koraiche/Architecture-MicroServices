package com.sid.msbanque;


import com.sid.msbanque.web.CompteRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class MyConfig {
    //@Bean // pour que cette methode s'execute au demarrage
    public ResourceConfig resourceConfig(){
        ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(CompteRestJaxRSAPI.class);
        return jerseyServlet;
    }
    //Pour exposer notre web service SOAP-> http://localhost:8887/BanqueWS?wsdl
    @Bean
    SimpleJaxWsServiceExporter serviceExporter(){
        SimpleJaxWsServiceExporter serviceExporter =  new SimpleJaxWsServiceExporter();
        serviceExporter.setBaseAddress("http://0.0.0.0:8887/");
        return serviceExporter;
    }
}
