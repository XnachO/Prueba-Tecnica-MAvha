package com.nachoseluy.prueba.mavha.repository;


import java.util.ArrayList;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nachoseluy.prueba.mavha.domain.Persona;



public interface PersonaRepository
		extends PagingAndSortingRepository<Persona, String>
{
	// Obtiene un envío a partir del número de seguimiento
	Persona findByDni(String dni);

	// Obtiene un envío a partir del número de seguimiento
	ArrayList<Persona> findByDniOrNombreOrEdad(String dni, String nombre,
			Integer edad);

}