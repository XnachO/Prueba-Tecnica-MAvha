package com.nachoseluy.prueba.mavha.rest;

import com.nachoseluy.prueba.mavha.model.PersonaRequest;
import com.nachoseluy.prueba.mavha.model.PersonaResponse;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-26T22:22:21.285-03:00")

@Api(value = "persona", description = "the persona API")
public interface PersonaApi {

    @ApiOperation(value = "", notes = "Listado de Personas con filtro por DNI, nombre y edad ", response = PersonaResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK ", response = PersonaResponse.class) })
    @RequestMapping(value = "/persona",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<PersonaResponse> personaGet( @ApiParam(value = "Numero de DNI ") @RequestParam(value = "dni", required = false) String dni,
         @ApiParam(value = "Nombre de la Persona ") @RequestParam(value = "nombre", required = false) String nombre,
         @ApiParam(value = "Edad de la Persona ") @RequestParam(value = "edad", required = false) Integer edad);


    @ApiOperation(value = "", notes = "Listado de personas ", response = PersonaResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK ", response = PersonaResponse.class) })
    @RequestMapping(value = "/persona/{idPersona}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<PersonaResponse> personaIdPersonaGet(@ApiParam(value = "Numero de DNI ",required=true ) @PathVariable("idPersona") String idPersona);


    @ApiOperation(value = "", notes = "Dar de alta una persona incluyendo una foto. ", response = PersonaResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK ", response = PersonaResponse.class) })
    @RequestMapping(value = "/persona",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<PersonaResponse> personaPost(@ApiParam(value = "Datos de la Persona "  ) @RequestBody PersonaRequest bodyEnvio);

}
