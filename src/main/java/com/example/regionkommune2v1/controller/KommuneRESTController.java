package com.example.regionkommune2v1.controller;

import com.example.regionkommune2v1.model.Kommune;
import com.example.regionkommune2v1.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
public class KommuneRESTController {

    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("/kommuner")
    public List<Kommune> getAllRegions() {
        return kommuneRepository.findAll();
    }

    @PostMapping("/kommune")
    @ResponseStatus(HttpStatus.CREATED)
    public Kommune postRegion(@RequestBody Kommune kommune) {
        System.out.println(kommune);
        return kommuneRepository.save(kommune);
    }

    @PutMapping("/kommune/{id}")
    public ResponseEntity<Kommune> updateCount(@PathVariable String id, @RequestBody Kommune kommune) {
        Optional<Kommune> optKommune = kommuneRepository.findById(id);
        if (optKommune.isPresent()) {
            kommuneRepository.save(kommune);
            return new ResponseEntity<>(kommune,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}


