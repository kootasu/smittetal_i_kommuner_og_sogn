package com.example.demo.service;

import com.example.demo.model.Commune;
import com.example.demo.model.Parish;
import com.example.demo.repository.CommuneRepository;
import com.example.demo.repository.ParishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CommuneService {

    @Autowired
    private CommuneRepository communeRepository;

    public void feedCommuneData(){
        String line = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/testjusterede_incidenser_kommuner_red01.csv"));
            while ((line = bufferedReader.readLine())!=null) {
                String[] data = line.split(";");
                Commune commune = new Commune();
                commune.setCommuneCode(Long.parseLong(data[1]));
                commune.setName(data[0]);
                commune.setIncidence(Double.parseDouble(data[2]));
                communeRepository.save(commune);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<Commune> findAll(){
        Set<Commune> communes = new HashSet<>();
        for (Commune commune : communeRepository.findAll()) {
            communes.add(commune);
        }
        return communes;
    }

}
