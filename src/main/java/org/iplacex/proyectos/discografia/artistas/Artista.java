package org.iplacex.proyectos.discografia.artistas;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/* Clase que representa un artista dentro de la colección artistas  */
@Document("artistas")

public class Artista {
// Identificador único del documento
@Id
public String _id;

// Nombre del artista
public String nombre;

// Lista de estilos musicales
public List<String> estilos;

// Año de fundación del artista o banda
public int anioFundacion;

// Indica si el artista sigue activo
public boolean estaActivo;
}
