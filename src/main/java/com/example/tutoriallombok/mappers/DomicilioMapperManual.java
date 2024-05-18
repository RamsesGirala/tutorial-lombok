package com.example.tutoriallombok.mappers;

import com.example.tutoriallombok.domain.dtos.DomicilioDto;
import com.example.tutoriallombok.domain.entities.Domicilio;
import org.springframework.stereotype.Component;

@Component
public class DomicilioMapperManual {

    public Domicilio domicilioDtoToDomicilio(DomicilioDto domicilioDto){
        return Domicilio.builder()
                .calle(domicilioDto.getCalle())
                .numero(domicilioDto.getNumero())
                .build();
    }

    public DomicilioDto domicilioToDomicilioDto(Domicilio domicilio){
        var domicilioDto = DomicilioDto.builder()
                .calle(domicilio.getCalle())
                .numero(domicilio.getNumero())
                .build();
        domicilioDto.setId(domicilioDto.getId());
        return domicilioDto;
    }


}
