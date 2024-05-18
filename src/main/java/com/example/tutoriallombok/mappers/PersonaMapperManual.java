package com.example.tutoriallombok.mappers;


import com.example.tutoriallombok.domain.dtos.PersonaDto;
import com.example.tutoriallombok.domain.dtos.PersonaInfoDto;
import com.example.tutoriallombok.domain.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class PersonaMapperManual {

    @Autowired
    private DomicilioMapperManual domicilioMapperManual;

    public Persona personaDtoToPersona(PersonaDto personaDto){
        return Persona.builder()
                .nombre(personaDto.getNombre())
                .apellido(personaDto.getApellido())
                .cuit(personaDto.getCuit())
                .dni(personaDto.getDni())
                .fechaNacimiento(personaDto.getFechaNacimiento())
                .domicilio(domicilioMapperManual.domicilioDtoToDomicilio(personaDto.getDomicilio()))
                .build();
    }

    public PersonaDto personaToPersonaDto(Persona persona){
        var personaDto = PersonaDto.builder()
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                .cuit(persona.getCuit())
                .dni(persona.getDni())
                .fechaNacimiento(persona.getFechaNacimiento())
                .domicilio(domicilioMapperManual.domicilioToDomicilioDto(persona.getDomicilio()))
                .build();
        personaDto.setId(personaDto.getId());
        return personaDto;
    }

    public PersonaInfoDto personaToPersonaInfoDto(Persona persona){
        var personaInfoDto = PersonaInfoDto.builder()
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                .calleDomicilio(persona.getDomicilio().getCalle())
                .numeroDomicilio(persona.getDomicilio().getNumero())
                .edad(Period.between(persona.getFechaNacimiento(), LocalDate.now()).getYears())
                .build();
        personaInfoDto.setId(persona.getId());
        return  personaInfoDto;
    }

}
