package org.iplacex.proyectos.discografia.discos;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("discos")
public class Disco {

    /* Identificador del disco */
    @Id
    public String _id;

    /* Identificador del artista */
    public String idArtista;

    /* Nombre del disco */
    public String nombre;

    /* Año de lanzamiento */
    public int anioLanzamiento;

    /* Lista de canciones */
    public List<String> canciones;

}