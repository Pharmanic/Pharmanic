package com.example.pharmanic.services;

import com.example.pharmanic.model.Ministry_Driver;
import com.example.pharmanic.model.Ministry_Track;
import com.example.pharmanic.repositories.Ministry_TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ministry_TrackService {

    @Autowired
    Ministry_TrackRepository ministry_trackRepository;

    public List<Ministry_Track> getMinistryTrackList(){
        List<Ministry_Track> ministry_trackList=ministry_trackRepository.findAll();
        return ministry_trackList;
    }

    //addDrivers
    public Integer addMinistryTrack(Ministry_Track ministry_track){
        ministry_trackRepository.save(ministry_track);
        return 1;
    }
}
