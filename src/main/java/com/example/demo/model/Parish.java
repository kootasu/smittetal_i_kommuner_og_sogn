package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Parish {

    @Id
    private long parishCode;

    private String name;
    private double incidence;
    private boolean isShutDown;
    private Date shutdownDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "commune_code")
    private Commune commune;



    public Parish(long parishCode, String name, double incidence, boolean isShutDown, Date shutdown_Date, Commune commune){
        this.parishCode = parishCode;
        this.name = name;
        this.incidence = incidence;
        this.isShutDown = isShutDown;
        this.shutdownDate = shutdown_Date;
        this.commune = commune;
    }

    public Parish() {
    }

    public long getParishCode() {
        return parishCode;
    }

    public void setParishCode(long parish_Code) {
        this.parishCode = parish_Code;
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

    public void setIncidence(double incidence) {
        this.incidence = incidence;
    }

    public boolean isShutDown() {
        return isShutDown;
    }

    public void setShutDown(boolean shutDown) {
        isShutDown = shutDown;
    }

    public Date getShutdownDate() {
        return shutdownDate;
    }

    public void setShutdownDate(Date shutdown_Date) {
        this.shutdownDate = shutdown_Date;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }
}
