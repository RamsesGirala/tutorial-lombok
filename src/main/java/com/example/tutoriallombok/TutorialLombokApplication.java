package com.example.tutoriallombok;

import com.example.tutoriallombok.domain.dtos.DomicilioDto;
import com.example.tutoriallombok.domain.dtos.PersonaDto;
import com.example.tutoriallombok.mappers.PersonaMapper;
import com.example.tutoriallombok.repositories.PersonaRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@Slf4j
public class TutorialLombokApplication {

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private PersonaMapper personaMapper;

	public static void main(String[] args) {
		SpringApplication.run(TutorialLombokApplication.class, args);

	}
	@Bean
	CommandLineRunner init() {
		return args -> {
			log.info("----------------ESTOY----FUNCIONANDO---------------------");
			// CREAR DATOS DEMO
			DomicilioDto domicilioDto = DomicilioDto.builder()
					.numero(2700)
					.calle("San Martin")
					.build();


			PersonaDto persona1Dto = PersonaDto.builder()
					.nombre("Juan")
					.apellido("Perez")
					.dni(42160786)
					.cuit(20421607866L)
					.fechaNacimiento(LocalDate.of(1998,5,10))
					.domicilio(domicilioDto).build();

			PersonaDto persona2Dto = PersonaDto.builder()
					.nombre("Martin")
					.apellido("Perez")
					.dni(40987324)
					.cuit(20409873246L)
					.fechaNacimiento(LocalDate.of(1995,3,15))
					.domicilio(domicilioDto).build();

			// GUARDAR EN BASE DE DATOS
			var persona1Entity = personaMapper.toEntity(persona1Dto);
			var persona2Entity = personaMapper.toEntity(persona2Dto);
			personaRepository.save(persona1Entity);
			personaRepository.save(persona2Entity);

			// BUSCAR PERSONA Y PERSONA INFO CON ID 1
			Long id = 1L;
			var persona = personaRepository.findById(id).get();
			var personaDto = personaMapper.toDto(persona);
			log.info("PersonaDto {}",personaDto);
			var personaInfoDto = personaMapper.toPersonaInfoDto(persona);
			log.info("PersonaInfoDto {}",personaInfoDto);
		};
	}
}
