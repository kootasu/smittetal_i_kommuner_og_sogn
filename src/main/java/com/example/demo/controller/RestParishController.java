package com.example.demo.controller;

import com.example.demo.model.Commune;
import com.example.demo.model.Parish;
import com.example.demo.repository.CommuneRepository;
import com.example.demo.repository.ParishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RestParishController {

    @Autowired
    ParishRepository parishRepository;
    @Autowired
    CommuneRepository communeRepository;
/*
    // HTTP GET List
    @GetMapping("/parish")
    public ResponseEntity<Iterable<Parish>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(parishRepository.findAll());
    }

    // HTTP GET by id/parish code
    @GetMapping("/parish/{parishCode}")
    public ResponseEntity<Optional<Parish>> findById(@PathVariable Long parishCode){
        Optional<Parish> optionalParish = parishRepository.findById(parishCode);
        if (optionalParish.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalParish);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalParish);
        }
    }

    // HTTP POST
    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @PostMapping(value = "/parish", consumes = "application/json")
    public ResponseEntity<String> create(@RequestBody Parish parish){
        Parish _parish = new Parish(parish.getParishCode(), parish.getName(), parish.getReproductionNumber(), parish.getShutdownDate(), parish.getCommune());

        // TODO: Den gældende commune bliver ikke opdateret – hvordan fixer jeg det?

        parishRepository.save(_parish);

        return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/parish/" + parish.getParishCode()).body("{'Message': 'Post created'}");
    }

    // HTTP PUT
    @PutMapping("parish/{parishCode}")
    public ResponseEntity<String> update(@PathVariable("parishCode") Long parishCode, @RequestBody Parish parish) {
        Optional<Parish> optionalParish = parishRepository.findById(parishCode);
        if (!optionalParish.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'Message' : 'Parish " + parishCode + " not found'");
        }
        parishRepository.save(parish);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{ 'Message' : 'updated' }");
    }

    // HTTP DELETE
    @DeleteMapping("/parish/{parishCode}")
    public ResponseEntity<String> delete(@PathVariable Long parishCode){
        Optional<Parish> optionalParish = parishRepository.findById(parishCode);
        if (!optionalParish.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ 'Message' : 'parish " + parishCode + " not found'}");
        }
        parishRepository.deleteById(parishCode);
        return ResponseEntity.status(HttpStatus.OK).body("{ 'Message' : 'deleted'}");
    }*/
}
