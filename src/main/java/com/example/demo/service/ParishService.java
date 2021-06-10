package com.example.demo.service;

import com.example.demo.model.Parish;
import com.example.demo.repository.CommuneRepository;
import com.example.demo.repository.ParishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ParishService {

    @Autowired
    private ParishRepository parishRepository;
    @Autowired
    private CommuneRepository communeRepository;

    public void feedParishData(){
        String line = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/sognedata_nedlukning_red01.csv"));
            while ((line = bufferedReader.readLine())!=null) {
                String[] data = line.split(";");
                Parish parish = new Parish();
                parish.setParishCode(Long.parseLong(data[0]));
                parish.setName(data[1]);
                parish.setIncidence(Double.parseDouble(data[2]));
                parish.setShutDown(Boolean.parseBoolean(data[3]));
                // TODO: Dato
                //parish.setShutdownDate(Date.parse(data[4]));
                parish.setCommune(communeRepository.getById(Long.parseLong(data[5])));
                parishRepository.save(parish);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<Parish> findAll(){
        Set<Parish> parishes = new HashSet<>();
        for (Parish parish : parishRepository.findAll()) {
            parishes.add(parish);
        }
        return parishes;
    }

    public Parish findById(Long parishCode){
        Optional<Parish> optionalParish = parishRepository.findById(parishCode);
        if (!optionalParish.isPresent()){
            throw new RuntimeException("Parish " + parishCode + " not found");
        }
        return optionalParish.get();
    }

    public Parish create(Parish parish) {
        return parishRepository.save(parish);
    }

    public Parish update(Parish parish) {
        // TODO: Check om den findes + fejlhåndtering, hvis den ikke gør
        return parishRepository.save(parish);
    }

    public void deleteById(Long parishCode) {
        parishRepository.deleteById(parishCode);
    }

}
