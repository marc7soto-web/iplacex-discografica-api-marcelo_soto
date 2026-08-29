package org.iplacex.proyectos.discografia.discos;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/* Repositorio para la colección discos */
public interface IDiscoRepository extends MongoRepository<Disco, String> {

    /* Obtiene los discos de un artista */
    @Query("{ 'idArtista': ?0 }")
    List<Disco> findDiscosByIdArtista(String idArtista);

}
