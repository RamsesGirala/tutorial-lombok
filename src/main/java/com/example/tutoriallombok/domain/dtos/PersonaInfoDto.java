package com.example.tutoriallombok.domain.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class PersonaInfoDto extends BaseDto{

    private String calleDomicilio;
    private Integer numeroDomicilio;
    private String nombre;
    private String apellido;
    private Integer edad;

}
