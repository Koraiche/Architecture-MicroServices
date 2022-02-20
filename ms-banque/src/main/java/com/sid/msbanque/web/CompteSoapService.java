package com.sid.msbanque.web;

import com.sid.msbanque.entities.Compte;
import com.sid.msbanque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/*
*/
@Component
@WebService(serviceName = "BanqueWS")
public class CompteSoapService {
    @Autowired
    private CompteRepository compteRepository;
    @WebMethod
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }
    @WebMethod
    public Compte getOne(@WebParam(name="id") Long id){
        return compteRepository.findById(id).get();
    }
    @WebMethod
    public Compte save(Compte compte){
        return compteRepository.save(compte);
    }
    @WebMethod
    public Compte update(Compte compte, @WebParam(name="id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }
    @WebMethod
    public void delete(@WebParam(name="id") Long id){
        compteRepository.deleteById(id);
    }
}
