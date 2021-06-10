package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Commune {

    @Id
    private long communeCode;
    private String name;
    private double incidence;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commune") // TODO: Skal der være cascade på?
    private Set<Parish> parishes;

    public Commune(long communeCode, String name, double incidence, Set<Parish> parishes){
        this.communeCode = communeCode;
        this.name = name;
        this.incidence = incidence;
        this.parishes = parishes;
    }

    public Commune() {
    }

    public long getCommuneCode() {
        return communeCode;
    }

    public void setCommuneCode(long commune_Code) {
        this.communeCode = commune_Code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncidence() {
        return incidence;
    }

    public void setIncidence(double totalIncidence) {
        this.incidence = totalIncidence;
    }

    public Set<Parish> getParishes() {
        return parishes;
    }

    public void setParishes(Set<Parish> parishes) {
        this.parishes = parishes;
    }
}
