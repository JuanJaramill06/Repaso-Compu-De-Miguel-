package com.example.tallerspring.service;

import com.example.tallerspring.model.Artist;

import java.util.List;

/**
 * Abstracción del servicio de artistas.
 * Los servlets dependen de esta interfaz y no de la implementación concreta (DIP).
 */
public interface IArtistService {

    Artist createArtist(String name, String nationality);

    List<Artist> getAllArtists();

    Artist getArtistByName(String name);

    void deleteArtist(long id);
}
