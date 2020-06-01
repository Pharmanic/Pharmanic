package com.example.pharmanic.web;

import com.example.pharmanic.model.Rdhs_Hospital_Current_Stock;
import com.example.pharmanic.model.Rdhs_Track;
import com.example.pharmanic.repositories.Rdhs_TrackRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
@RestController
@RequestMapping("/api")
public class Rdhs_TrackController {
    private Rdhs_TrackRepository rdhs_trackRepository;

    public Rdhs_TrackController(Rdhs_TrackRepository rdhs_trackRepository) {
        super();
        this.rdhs_trackRepository=rdhs_trackRepository;
    }

    @GetMapping("/alltrack")
    Collection<Rdhs_Track> allTrack() {
        return rdhs_trackRepository.findAll();
    }

    @PostMapping("/saveTrack")
    ResponseEntity<Rdhs_Track> newTrackRecord(@Validated @RequestBody Rdhs_Track rdhs_track)throws URISyntaxException{
        Rdhs_Track result=rdhs_trackRepository.save(rdhs_track);
        return ResponseEntity.created(new URI("/api/saveTrack"+result.getTrack_id())).body(result);
    }

    @PutMapping("/updateTrack{id}")
    ResponseEntity<Rdhs_Track> updateTrack(@Validated @RequestBody Rdhs_Track rdhs_track){
        Rdhs_Track result=rdhs_trackRepository.save(rdhs_track);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("deleteTrack/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        rdhs_trackRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/idgenerate")

    String generateId() {
        return rdhs_trackRepository.findNextId();
    }
}
