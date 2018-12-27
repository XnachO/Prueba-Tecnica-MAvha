package com.nachoseluy.prueba.mavha.web.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nachoseluy.prueba.mavha.model.PersonaRequest;
import com.nachoseluy.prueba.mavha.model.PersonaResponse;
import com.nachoseluy.prueba.mavha.rest.PersonaApi;

import io.swagger.annotations.ApiParam;



@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-26T22:22:21.285-03:00")

@Controller
@RequestMapping(value="/pruebamavha/v1")
public class PersonaApiController implements PersonaApi
{

	public ResponseEntity<PersonaResponse> personaGet(
			@ApiParam(value = "Numero de DNI ") @RequestParam(value = "dni", required = false) String dni,
			@ApiParam(value = "Nombre de la Persona ") @RequestParam(value = "nombre", required = false) String nombre,
			@ApiParam(value = "Edad de la Persona ") @RequestParam(value = "edad", required = false) Integer edad)
	{
		// do some magic!
		return new ResponseEntity<PersonaResponse>(HttpStatus.OK);
	}

	public ResponseEntity<PersonaResponse> personaIdPersonaGet(
			@ApiParam(value = "Numero de DNI ", required = true) @PathVariable("idPersona") String idPersona)
	{
		// do some magic!
		return new ResponseEntity<PersonaResponse>(HttpStatus.OK);
	}

	public ResponseEntity<PersonaResponse> personaPost(
			@ApiParam(value = "Datos de la Persona ") @RequestBody PersonaRequest bodyEnvio)
	{
		// do some magic!
		return new ResponseEntity<PersonaResponse>(HttpStatus.OK);
	}

}
