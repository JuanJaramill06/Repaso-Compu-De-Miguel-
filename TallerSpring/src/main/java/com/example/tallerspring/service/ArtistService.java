package com.example.tallerspring.service;

import com.example.tallerspring.model.Artist;
import com.example.tallerspring.repository.IArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArtistService implements IArtistService {

    @Autowired
    private IArtistRepository artistRepository;

    public void setArtistRepository(IArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Artist createArtist(String name, String nationality) {
        Artist artist = new Artist(name, nationality);
        return artistRepository.save(artist);
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist getArtistByName(String name) {
        return artistRepository.findByName(name);
    }

    @Override
    public void deleteArtist(long id) {
        artistRepository.deleteById(id);
    }
}
