package com.example.tutoriallombok.domain.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class PersonaDto extends BaseDto{

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Integer dni;
    private Long cuit;
    private DomicilioDto domicilio;

}
