package com.sid.msbanque.entities;

import org.springframework.data.rest.core.config.Projection;

// http://localhost:8082/api/comptes/1?projection=mobile
@Projection(name = "mobile", types = Compte.class)
public interface CompteProjection2 {
    public double getSolde();
    public TypeCompte getType();
}
