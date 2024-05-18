package com.example.tutoriallombok.mappers;

import com.example.tutoriallombok.domain.dtos.PersonaDto;
import com.example.tutoriallombok.domain.dtos.PersonaInfoDto;
import com.example.tutoriallombok.domain.entities.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.Period;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    Persona toEntity(PersonaDto personaDto);

    PersonaDto toDto(Persona persona);

    @Mapping(source = "domicilio.numero", target = "numeroDomicilio")
    @Mapping(source = "domicilio.calle", target = "calleDomicilio")
    @Mapping(target = "edad", expression = "java(calcularEdad(persona.getFechaNacimiento()))")
    PersonaInfoDto toPersonaInfoDto(Persona persona);

    @Named("calcularEdad")
    default int calcularEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

}
