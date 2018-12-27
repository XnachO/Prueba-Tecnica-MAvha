package com.nachoseluy.prueba.mavha.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



/**
 * Persist AuditEvent managed by the Spring Boot actuator
 * 
 * @see org.springframework.boot.actuate.audit.AuditEvent
 */
@Entity
@Table(name = "persona")
public class Persona implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4179335074182261200L;

	@Id
	@Column(name = "dni")
	private String dni;

	@NotNull
	@Column(nullable = false)
	private String nombre;

	@NotNull
	@Column(nullable = false)
	private String apellido;

	@NotNull
	@Column(nullable = false)
	private Integer edad;

	private String foto;

	public String getDni()
	{
		return dni;
	}

	public void setDni(String dni)
	{
		this.dni = dni;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getApellido()
	{
		return apellido;
	}

	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}

	public Integer getEdad()
	{
		return edad;
	}

	public void setEdad(Integer edad)
	{
		this.edad = edad;
	}

	public String getFoto()
	{
		return foto;
	}

	public void setFoto(String foto)
	{
		this.foto = foto;
	}

}
