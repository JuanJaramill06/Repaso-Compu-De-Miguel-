package com.example.tallerspring.service;

import com.example.tallerspring.model.Track;

import java.util.List;

/**
 * Abstracción del servicio de canciones.
 * Los servlets dependen de esta interfaz y no de la implementación concreta (DIP).
 */
public interface ITrackService {

    Track createTrack(String title, String genre, long duration, String albumTitle, List<Long> artistIds);

    List<Track> getAllTracks();

    void deleteTrack(long id);
}
