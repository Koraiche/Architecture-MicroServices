package com.sid.msbanque;

import com.sid.msbanque.entities.Client;
import com.sid.msbanque.entities.Compte;
import com.sid.msbanque.entities.TypeCompte;
import com.sid.msbanque.repositories.ClientRepository;
import com.sid.msbanque.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
public class MsBanqueApplication {

    public static void main(String[] args) {

        SpringApplication.run(MsBanqueApplication.class, args);

    }
    @Bean
    CommandLineRunner start(CompteRepository compteRepository,
                            RepositoryRestConfiguration repositoryRestConfiguration,
                            ClientRepository clientRepository){
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Compte.class);
            repositoryRestConfiguration.exposeIdsFor(Client.class);
            Client c1 = clientRepository.save(new Client(null, "Fahd", null));
            Client c2 =clientRepository.save(new Client(null, "Ikram", null));
            compteRepository.save(new Compte(null,Math.random()*9000, new Date(), TypeCompte.EPARGNE,c1));
            compteRepository.save(new Compte(null,Math.random()*9000, new Date(), TypeCompte.COURANT,c2));
            compteRepository.save(new Compte(null,Math.random()*9000, new Date(), TypeCompte.EPARGNE,c1));
            compteRepository.findAll().forEach(c->{
                System.out.println(c.getSolde());/*ici on a remplacer tostring par get solde, car une fois que
                la fonction findall est finis elle a recuperer les compte mais elle n'a pas recuperer ses client
                (Lazy), donc une fois qu'on a appeler tostring, cette fonction essaie d'afficher le client alors
                que note findAll ne l'a pas charger dans la memoire ! pour eviter tel probleme on va opter pour
                le getSolde une fois qu'ona rajouter notre class client sinon on specifie le type du fetch EAGER
                dans notre relatiobn du mapping objet relationnelle dans Class compte : fetch = FetchType.EAGER*/
            });
        };
    }
}
