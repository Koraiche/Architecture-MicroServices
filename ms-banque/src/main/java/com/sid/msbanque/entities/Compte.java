package com.sid.msbanque.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private TypeCompte type;
    @ManyToOne
    private Client client;
}
/*
Les specifications c'est des API qui possedent plusieurs implementation
    ex SOAP    : jaxws(ses implementations c'est AXIS et CXF)
    ex RESTful : jaxRS(ses implementations c'est Jersey...) jaxRS est utilisé normalement
                 hors Spring car avec spring il ya d'autres solutions
*/