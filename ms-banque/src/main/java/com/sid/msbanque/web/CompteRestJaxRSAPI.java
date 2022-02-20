package com.sid.msbanque.web;

import com.sid.msbanque.entities.Compte;
import com.sid.msbanque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/*
    Spring ne peut fair l'injection des dependance quesi c'est lui qui a créer la class
    CompteRestJaxRSAPI tandis que ici PATH n'est pas une annotation spring, pour resoudre ce
    probleme on rajout l'annotation Component, ce qui dit que c'est un composant Spring, c'est
    spring qui va l'instancier, doncl'injection des dependance va avoir lieu
    NB : ici ce n'est pas dispatcher servlet qui va faire le travail, mais plutot une autre servlet,
    c'est Jersey
    Pour que ca marche il faut indiquer a spring que au demarrage il faut deplloyer Jersey, et
    pour faire cela, il faut declarer Jersey dans web.xml, mais ici dans spring on a pas besoin
    de creer un web.xml pour creer des servlet, spring nous donne d'autres moyenspour faire
    l'integration, ex dans le package de l'application on va creer une classe deconfiguration
    MyConfig.java

*/
@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
    @Autowired
    private CompteRepository compteRepository;
    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) // LE TYPE DE RETOUR
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }
    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON}) // LE TYPE DE RETOUR
    public Compte getOne(@PathParam(value="id") Long id){
        return compteRepository.findById(id).get();
    }
    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON}) // LE TYPE DE RETOUR
    public Compte save(Compte compte){
        return compteRepository.save(compte);
    }
    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON}) // LE TYPE DE RETOUR
    public Compte update(Compte compte, @PathParam(value="id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }
    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON}) // LE TYPE DE RETOUR
    public void delete(@PathParam(value="id") Long id){
        compteRepository.deleteById(id);
    }
}
