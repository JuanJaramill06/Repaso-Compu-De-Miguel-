package com.example.tallerspring.repository;

import com.example.tallerspring.model.Artist;
import com.example.tallerspring.model.Track;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TrackRepository implements ITrackRepository {

    private Map<Long, Track> tracks = new HashMap<>();
    private long currentId;

    @PostConstruct
    public void init() {

    }

    @Override
    public List<Track> findAll() {
        return new ArrayList<>(tracks.values());
    }

    @Override
    public Track findById(long id) {
        return tracks.get(id);
    }

    @Override
    public Track findByTitle(String title) {
        return tracks.values().stream().filter(t -> t.getTitle().equals(title)).findFirst().orElse(null);
    }

    @Override
    public Track save(Track track) {
        currentId++;
        track.setId(currentId);
        tracks.put(currentId, track);
        return track;
    }

    @Override
    public void deleteById(long id) {
        tracks.remove(id);
    }

}
