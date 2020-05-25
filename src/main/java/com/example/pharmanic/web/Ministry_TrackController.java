package com.example.pharmanic.web;

import com.example.pharmanic.model.Ministry_Driver;
import com.example.pharmanic.model.Ministry_Track;
import com.example.pharmanic.repositories.Ministry_TrackRepository;
import com.example.pharmanic.services.Ministry_TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Ministry_TrackController {

    @Autowired
    Ministry_TrackRepository ministry_trackRepository;

    @Autowired
    Ministry_TrackService ministry_trackService;

    @GetMapping("/ministrytracks")
    public List<Ministry_Track> getMinistryTrackList(){
        return ministry_trackService.getMinistryTrackList();
    }

    @PostMapping("/ministry_track/add")
    public Integer addMinistryTrack(@RequestBody Ministry_Track ministry_track){
        System.out.println("in controller");
        return ministry_trackService.addMinistryTrack(ministry_track);
    }
}
