package com.example.tutoriallombok.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@Entity
public class Persona extends Base{

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Integer dni;
    private Long cuit;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Domicilio domicilio;

}
