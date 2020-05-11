package com.example.pharmanic.web;

import com.example.pharmanic.model.Ministry_Track;
import com.example.pharmanic.model.Ministry_TrackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Ministry_TrackController {
    private final Logger log = LoggerFactory.getLogger(Ministry_TrackController.class);
    private Ministry_TrackRepository ministry_trackRepository;

    public Ministry_TrackController(Ministry_TrackRepository ministry_trackRepository) {
        this.ministry_trackRepository = ministry_trackRepository;
    }

    @GetMapping("/ministrytracks")
    Collection<Ministry_Track> ministrytracks(){
        return ministry_trackRepository.findAll();
    }

    @GetMapping("/ministrytrack/{id}")
    ResponseEntity<?> getMinistrytrack(@PathVariable Long track_id){
        Optional<Ministry_Track> ministry_track = ministry_trackRepository.findById(track_id);
        return ministry_track.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/ministrytrack")
    ResponseEntity<Ministry_Track> createMinistrytrack(@Valid @RequestBody Ministry_Track ministry_track)throws URISyntaxException{
        log.info("Request to create Ministry track: {}",ministry_track);
        Ministry_Track result = ministry_trackRepository.save(ministry_track);
        return ResponseEntity.created(new URI("/api/ministrytrack/"+result.getTrack_id()))
                .body(result);
    }

    @DeleteMapping("/ministrytrack/{id}")
    public ResponseEntity<?> deleteMinistrytrack(@PathVariable Long track_id){
        log.info("Request to delete ministry track: {}",track_id);
        ministry_trackRepository.deleteById(track_id);
        return ResponseEntity.ok().build();
    }
}
