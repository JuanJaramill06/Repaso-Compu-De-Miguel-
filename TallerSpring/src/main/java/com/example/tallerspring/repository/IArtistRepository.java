package com.example.tallerspring.repository;

import com.example.tallerspring.model.Artist;

import java.util.List;

/**
 * Abstracción del repositorio de artistas.
 * El servicio depende de esta interfaz y no de una implementación concreta (DIP).
 */
public interface IArtistRepository {

    List<Artist> findAll();

    Artist findById(long id);

    Artist findByName(String name);

    Artist save(Artist artist);

    void deleteById(long id);
}
