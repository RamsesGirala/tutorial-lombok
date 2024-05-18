package com.example.tutoriallombok.domain.entities;

import jakarta.persistence.Entity;
import lombok.extern.slf4j.Slf4j;

@Entity
public class DomicilioSinLombok extends Base{

    private String calle;
    private Integer numero;


    public DomicilioSinLombok() {
    }

    public DomicilioSinLombok(String calle, Integer numero) {
        this.calle = calle;
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "DomicilioSinLombok{" +
                "calle='" + calle + '\'' +
                ", numero=" + numero +
                '}';
    }

}
