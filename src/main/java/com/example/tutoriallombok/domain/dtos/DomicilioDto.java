package com.example.tutoriallombok.domain.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class DomicilioDto extends BaseDto{

    private String calle;
    private Integer numero;

}
