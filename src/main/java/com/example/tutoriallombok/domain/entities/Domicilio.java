package com.example.tutoriallombok.domain.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@Entity
public class Domicilio extends Base{

    private String calle;
    private Integer numero;

}
