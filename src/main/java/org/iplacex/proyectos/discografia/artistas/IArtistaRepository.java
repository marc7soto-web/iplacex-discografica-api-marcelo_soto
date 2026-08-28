package org.iplacex.proyectos.discografia.artistas;

import org.springframework.data.mongodb.repository.MongoRepository;

/* Repositorio para la colección artistas */
public interface IArtistaRepository extends MongoRepository<Artista, String> {

}