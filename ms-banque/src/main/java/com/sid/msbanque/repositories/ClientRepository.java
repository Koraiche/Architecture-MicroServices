package com.sid.msbanque.repositories;

import com.sid.msbanque.entities.Client;
import com.sid.msbanque.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
}
