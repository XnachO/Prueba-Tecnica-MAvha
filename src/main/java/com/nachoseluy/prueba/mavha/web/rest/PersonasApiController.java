package com.nachoseluy.prueba.mavha.web.rest;


import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nachoseluy.prueba.mavha.domain.Persona;
import com.nachoseluy.prueba.mavha.model.PersonaRequest;
import com.nachoseluy.prueba.mavha.model.PersonaResponse;
import com.nachoseluy.prueba.mavha.repository.PersonaRepository;
import com.nachoseluy.prueba.mavha.rest.PersonasApi;

import io.swagger.annotations.ApiParam;



@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-26T22:22:21.285-03:00")

@Controller
@RequestMapping(value = "/pruebamavha/v1")
public class PersonasApiController implements PersonasApi
{

	@Autowired
	PersonaRepository personaRepository;

	private static final Logger LOG = Logger.getLogger(PersonasApiController.class);

	public ResponseEntity<PersonaResponse> personasGet(
			@ApiParam(value = "Numero de DNI ") @RequestParam(value = "dni", required = false) String dni,
			@ApiParam(value = "Nombre de la Persona ") @RequestParam(value = "nombre", required = false) String nombre,
			@ApiParam(value = "Edad de la Persona ") @RequestParam(value = "edad", required = false) Integer edad)
	{
		PersonaResponse response = new PersonaResponse();

		LOG.info(
				String.format("Busco personas con dni = %s, nombre = %s, edad = %d",
						dni, nombre, edad));

		try {
			ArrayList<Persona> personasEncontradas = personaRepository
					.findByDniOrNombreOrEdad(dni, nombre, edad);

			// Recorro el resultado de personas encontradas
			for (short i = 0; i < personasEncontradas.size(); i++) {
				PersonaRequest persona = new PersonaRequest();
				persona.setDni(personasEncontradas.get(i).getDni());
				persona.setNombre(personasEncontradas.get(i).getNombre());
				persona.setApellido(personasEncontradas.get(i).getApellido());
				persona.setEdad(personasEncontradas.get(i).getEdad());
				persona.setFoto(personasEncontradas.get(i).getFoto());

				response.add(persona);
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return new ResponseEntity<PersonaResponse>(response, HttpStatus.OK);
	}

	public ResponseEntity<PersonaResponse> personasIdPersonaGet(
			@ApiParam(value = "Numero de DNI ", required = true) @PathVariable("idPersona") String idPersona)
	{
		PersonaResponse response = new PersonaResponse();

		LOG.info(String.format("Busco persona con idPersona = %s", idPersona));

		try {
			Persona personaGuardada = personaRepository.findByDni(idPersona);

			PersonaRequest persona = new PersonaRequest();
			persona.setDni(personaGuardada.getDni());
			persona.setNombre(personaGuardada.getNombre());
			persona.setApellido(personaGuardada.getApellido());
			persona.setEdad(personaGuardada.getEdad());
			persona.setFoto(personaGuardada.getFoto());

			response.add(persona);

		} catch (Exception e) {
			LOG.error(e);
		}

		return new ResponseEntity<PersonaResponse>(response, HttpStatus.OK);
	}

	public ResponseEntity<PersonaResponse> personasPost(
			@ApiParam(value = "Datos de la Persona ") @RequestBody PersonaRequest datosPersona)
	{
		PersonaResponse response = new PersonaResponse();

		Persona nuevaPersona = new Persona();

		nuevaPersona.setDni(datosPersona.getDni());
		nuevaPersona.setNombre(datosPersona.getNombre());
		nuevaPersona.setApellido(datosPersona.getApellido());
		nuevaPersona.setEdad(datosPersona.getEdad());
		nuevaPersona.setFoto(datosPersona.getFoto());

		try {
			Persona personaGuardada = personaRepository.save(nuevaPersona);

			PersonaRequest persona = new PersonaRequest();
			persona.setDni(personaGuardada.getDni());
			persona.setNombre(personaGuardada.getNombre());
			persona.setApellido(personaGuardada.getApellido());
			persona.setEdad(personaGuardada.getEdad());
			persona.setFoto(personaGuardada.getFoto());

			response.add(persona);

		} catch (Exception e) {
			LOG.error(e);
		}

		return new ResponseEntity<PersonaResponse>(response, HttpStatus.OK);
	}

}
