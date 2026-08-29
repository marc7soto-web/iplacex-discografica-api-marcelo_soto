package org.iplacex.proyectos.discografia.discos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.iplacex.proyectos.discografia.artistas.IArtistaRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DiscoController {

    /* Repositorio de discos */
    @Autowired
    private IDiscoRepository discoRepository;

    /* Repositorio de artistas */
    @Autowired
    private IArtistaRepository artistaRepository;

    /* Inserta un nuevo disco */
    @PostMapping(value = "/disco", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Disco> HandlePostDiscoRequest(@RequestBody Disco disco) {

        if (!artistaRepository.existsById(disco.idArtista)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Disco discoGuardado = discoRepository.save(disco);

        return new ResponseEntity<>(discoGuardado, HttpStatus.CREATED);
    }

    /* Obtiene todos los discos */
    @GetMapping(value = "/discos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Disco>> HandleGetDiscosRequest() {

        return new ResponseEntity<>(discoRepository.findAll(), HttpStatus.OK);
    }

    /* Obtiene un disco por id */
    @GetMapping(value = "/disco/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Disco> HandleGetDiscoRequest(@PathVariable String id) {

        Optional<Disco> disco = discoRepository.findById(id);

        if (disco.isPresent()) {
            return new ResponseEntity<>(disco.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /* Obtiene los discos de un artista */
    @GetMapping(value = "/artista/{id}/discos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Disco>> HandleGetDiscosByArtistaRequest(@PathVariable String id) {

        List<Disco> discos = discoRepository.findDiscosByIdArtista(id);

        return new ResponseEntity<>(discos, HttpStatus.OK);
    }

}