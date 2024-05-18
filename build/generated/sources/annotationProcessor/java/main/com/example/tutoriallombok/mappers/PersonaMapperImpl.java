package com.example.tutoriallombok.mappers;

import com.example.tutoriallombok.domain.dtos.DomicilioDto;
import com.example.tutoriallombok.domain.dtos.PersonaDto;
import com.example.tutoriallombok.domain.dtos.PersonaInfoDto;
import com.example.tutoriallombok.domain.entities.Domicilio;
import com.example.tutoriallombok.domain.entities.Persona;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-18T16:49:30-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Microsoft)"
)
@Component
public class PersonaMapperImpl implements PersonaMapper {

    @Override
    public Persona toEntity(PersonaDto personaDto) {
        if ( personaDto == null ) {
            return null;
        }

        Persona.PersonaBuilder persona = Persona.builder();

        persona.nombre( personaDto.getNombre() );
        persona.apellido( personaDto.getApellido() );
        persona.fechaNacimiento( personaDto.getFechaNacimiento() );
        persona.dni( personaDto.getDni() );
        persona.cuit( personaDto.getCuit() );
        persona.domicilio( domicilioDtoToDomicilio( personaDto.getDomicilio() ) );

        return persona.build();
    }

    @Override
    public PersonaDto toDto(Persona persona) {
        if ( persona == null ) {
            return null;
        }

        PersonaDto.PersonaDtoBuilder personaDto = PersonaDto.builder();

        personaDto.nombre( persona.getNombre() );
        personaDto.apellido( persona.getApellido() );
        personaDto.fechaNacimiento( persona.getFechaNacimiento() );
        personaDto.dni( persona.getDni() );
        personaDto.cuit( persona.getCuit() );
        personaDto.domicilio( domicilioToDomicilioDto( persona.getDomicilio() ) );

        return personaDto.build();
    }

    @Override
    public PersonaInfoDto toPersonaInfoDto(Persona persona) {
        if ( persona == null ) {
            return null;
        }

        PersonaInfoDto.PersonaInfoDtoBuilder personaInfoDto = PersonaInfoDto.builder();

        personaInfoDto.numeroDomicilio( personaDomicilioNumero( persona ) );
        personaInfoDto.calleDomicilio( personaDomicilioCalle( persona ) );
        personaInfoDto.nombre( persona.getNombre() );
        personaInfoDto.apellido( persona.getApellido() );

        personaInfoDto.edad( calcularEdad(persona.getFechaNacimiento()) );

        return personaInfoDto.build();
    }

    protected Domicilio domicilioDtoToDomicilio(DomicilioDto domicilioDto) {
        if ( domicilioDto == null ) {
            return null;
        }

        Domicilio.DomicilioBuilder domicilio = Domicilio.builder();

        domicilio.calle( domicilioDto.getCalle() );
        domicilio.numero( domicilioDto.getNumero() );

        return domicilio.build();
    }

    protected DomicilioDto domicilioToDomicilioDto(Domicilio domicilio) {
        if ( domicilio == null ) {
            return null;
        }

        DomicilioDto.DomicilioDtoBuilder domicilioDto = DomicilioDto.builder();

        domicilioDto.calle( domicilio.getCalle() );
        domicilioDto.numero( domicilio.getNumero() );

        return domicilioDto.build();
    }

    private Integer personaDomicilioNumero(Persona persona) {
        if ( persona == null ) {
            return null;
        }
        Domicilio domicilio = persona.getDomicilio();
        if ( domicilio == null ) {
            return null;
        }
        Integer numero = domicilio.getNumero();
        if ( numero == null ) {
            return null;
        }
        return numero;
    }

    private String personaDomicilioCalle(Persona persona) {
        if ( persona == null ) {
            return null;
        }
        Domicilio domicilio = persona.getDomicilio();
        if ( domicilio == null ) {
            return null;
        }
        String calle = domicilio.getCalle();
        if ( calle == null ) {
            return null;
        }
        return calle;
    }
}
