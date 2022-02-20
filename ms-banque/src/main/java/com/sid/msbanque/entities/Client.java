package com.sid.msbanque.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "client")
    @XmlTransient @JsonIgnore
// car dans le service SOAP on aura une boucle infinie entre la selection des clients et leurs
    // comptes prcq JaxB ne traite pas cette erreur, contrairement a spring data Jpa
    private Collection<Compte> comptes;

}
