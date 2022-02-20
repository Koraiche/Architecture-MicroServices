package com.sid.msbanque.repositories;

import com.sid.msbanque.entities.Compte;
import com.sid.msbanque.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

// 3eme methode SpringData Rest, pour la configurer on peut ajouter un path dans le fichier application.properties
//pour accedez on peut ecrire -> http://localhost:8082/api/comptes?page=0&size=2&sort=solde,desc
//unefois le path est configurer on peut ensuite exposer les ID car spring data les cache par defaut, dans le
//fichier MsBanqueApplication.
// Spring data rest nous propose les projections, il servent a filtrer les attributs d'un qu'on veut retourner
//au cas ou l'objet en contient plusieurs! c'est ca le probleme avec le restful, quand on demande une ressource,
// on est obligé de recuperer tt les attributs de la ressource, c'est pour ca que facebook a developper Graphql
// il est mieux que rest car dans la requete on dit qu'on veut la liste des compte et aussi on specifie quelles
//attributs on veut recuperer, spring data rest offre quelque chose de similaire-> Les projections, la difference
//c'est que GraphQL ne cree pas des recette mais plutot le client choisis ce qu'il veut alors que les projections
//on doit les creer
//NB : les projections doivent etre créee dans le meme package que les entité qu'on veut filtrer, sinon ca marche pas
//

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long> {

    @RestResource(path="/byType")
    public List<Compte> findByType(@Param("t") TypeCompte typeCompte);
    // apres avoir ajouter @RestRessource et @Param on va acceder a cette query comme il suit :
    //http://localhost:8082/api/comptes/search/byType?t=COURANT
    //au lieu de : //http://localhost:8082/api/comptes/search/findByType?typeCompte=COURANT

}
