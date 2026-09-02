package com.example.tallerspring.repository;

import com.example.tallerspring.model.Track;

import java.util.List;

/**
 * Abstracción del repositorio de canciones.
 * El servicio depende de esta interfaz y no de una implementación concreta (DIP).
 */
public interface ITrackRepository {

    List<Track> findAll();

    Track findById(long id);

    Track findByTitle(String title);

    Track save(Track track);

    void deleteById(long id);
}
