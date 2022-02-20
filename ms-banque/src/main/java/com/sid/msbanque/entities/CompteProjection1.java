package com.sid.msbanque.entities;


import org.springframework.data.rest.core.config.Projection;


// http://localhost:8082/api/comptes/1?projection=solde
@Projection(name="solde", types = Compte.class)
public interface CompteProjection1 {
    public double getSolde();
}
