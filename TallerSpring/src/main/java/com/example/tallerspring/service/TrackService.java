package com.example.tallerspring.service;

import com.example.tallerspring.model.Artist;
import com.example.tallerspring.model.Track;
import com.example.tallerspring.repository.IArtistRepository;
import com.example.tallerspring.repository.ITrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrackService implements ITrackService {

    @Autowired
    private ITrackRepository trackRepository;
    @Autowired
    private IArtistRepository artistRepository;

    public void setTrackRepository(ITrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public void setArtistRepository(IArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Track createTrack(String title, String genre, long duration, String albumTitle, List<Long> artistIds) {

        Track track = new Track(title, genre, duration, albumTitle);
        trackRepository.save(track);

        for (Long id : artistIds) {
            Artist artist = artistRepository.findById(id);
            if (artist != null) {
                artist.addTrack(track);
            }
        }

        return track;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public void deleteTrack(long id) {
        Track track = trackRepository.findById(id);

        if (track != null) {
            for (Artist artist : track.getArtists()) {
                artist.removeTrack(track);
            }
            trackRepository.deleteById(id);
        }
    }
}
