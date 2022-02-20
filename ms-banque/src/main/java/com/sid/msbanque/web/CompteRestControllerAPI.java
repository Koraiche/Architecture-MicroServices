package com.sid.msbanque.web;

import com.sid.msbanque.entities.Compte;
import com.sid.msbanque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/*
    La methode RESTCONTROLLER est plus simple, car on utilise dispatcher servlet, cad on utilise spring MVC,
    mais le standard dans les entreprise c'est JaxRS, etude de cas : MongoDB ce n'est pas des base de donnes
    relationnelles, CAD Jpa ne marche pas, alors que JEE n'a pas encore une specifications pour les bases de donnes
    NoSQL, dans ce cas on va utiliser Spring Data car il marche avec les BDnoSQL.

    "/comptes" ne peut pas etre testé avec le browser, car on a utilisé les format XML ET JSON a la fois dans notre API,
     notre browser ne saura pas quelle format retourner, donc il faut utiliser un outil comme SOAPUI

*/
//@RestController
@RequestMapping("banque")
public class CompteRestControllerAPI {
    @Autowired
    private CompteRepository compteRepository;
    @GetMapping(path="/comptes",produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE, org.springframework.http.MediaType.APPLICATION_XML_VALUE})
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }

    @GetMapping(path="/comptes/{id}")
    public Compte getOne(@PathVariable Long id){
        return compteRepository.findById(id).get();
    }

    @PostMapping("/comptes")
    public Compte save(@RequestBody Compte compte){
        return compteRepository.save(compte);
    }

    @PutMapping("/comptes/{id}")
    public Compte update(@RequestBody Compte compte, @PathVariable Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @DeleteMapping("/comptes/{id}")
    public void delete(@PathVariable Long id){
        compteRepository.deleteById(id);
    }
}
