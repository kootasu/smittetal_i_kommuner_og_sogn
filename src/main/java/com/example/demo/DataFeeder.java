package com.example.demo;

import com.example.demo.model.Commune;
import com.example.demo.model.Parish;
import com.example.demo.repository.CommuneRepository;
import com.example.demo.repository.ParishRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataFeeder {

    @Autowired
    private CommuneRepository communeRepository;
    @Autowired
    private ParishRepository parishRepository;

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

}
