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
import java.util.Set;

@RestController
public class RestCommuneController {

    @Autowired
    CommuneRepository communeRepository;
    @Autowired
    ParishRepository parishRepository;
/*
    // HTTP GET List
    @GetMapping("/commune") // TODO: Evt. omdøbe sider til dansk senere
    public ResponseEntity<Iterable<Commune>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(communeRepository.findAll());
    }

    // HTTP GET by id/parish code
    @GetMapping("/commune/{communeCode}")
    public ResponseEntity<Optional<Commune>> findById(@PathVariable Long communeCode){
        Optional<Commune> optionalCommune = communeRepository.findById(communeCode);
        if (optionalCommune.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalCommune);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalCommune);
        }
    }

    // HTTP POST
    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @PostMapping(value = "/commune", consumes = "application/json")
    public ResponseEntity<String> create(@RequestBody Commune commune){
        //gem commune, så der er et id tilknyttet til den nye opskrift til mapning i modsat retning
        //_recipe_id kan så bruges som fremmenøgle i notes, ingredients og categories
        Commune _commune = new Commune(commune.getCommuneCode(),commune.getName(), commune.getParishes());
        //glemt i undervisning torsdag - sørger for ny primary key til brug som fremmednøgle i andre klasser
        communeRepository.save(_commune);

        Set<Parish> _parishes = commune.getParishes();
        //iterer igennem _parishes og tilføj dem
        for (Parish parish: _parishes) {
            //sæt fremmednøgle til communeCode i parish
            parish.setCommune(_commune);
            parishRepository.save(parish);
        }
        //ikke nødvendigt at tilføje til _commune, da fremmednøglen er i _parish

        //opdater _commune efter tilføjelse af fremmednøgle til _parish
        communeRepository.save(_commune);

        //endelig kan vi sende svar med location
        return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/commune/" + commune.getCommuneCode())
                .body("{'Message': 'Post created'}");

    }

    // HTTP PUT
    @PutMapping("commune/{communeCode}")
    public ResponseEntity<String> update(@PathVariable("communeCode") Long communeCode, @RequestBody Commune commune) {
        Optional<Commune> optionalCommune = communeRepository.findById(communeCode);
        if (!optionalCommune.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'Message' : 'Commune " + communeCode + " not found'");
        }
        communeRepository.save(commune);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{ 'Message' : 'updated' }");
    }

    // HTTP DELETE
    @DeleteMapping("/commune/{communeCode}")
    public ResponseEntity<String> delete(@PathVariable Long communeCode){
        Optional<Commune> optionalCommune = communeRepository.findById(communeCode);
        if (!optionalCommune.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ 'Message' : 'commune " + communeCode + " not found'}");
        }
        communeRepository.deleteById(communeCode);
        return ResponseEntity.status(HttpStatus.OK).body("{ 'Message' : 'deleted'}");
    }*/
}
