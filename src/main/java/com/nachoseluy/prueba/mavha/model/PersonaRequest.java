package com.nachoseluy.prueba.mavha.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
/**
 * PersonaRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-26T22:22:21.285-03:00")

public class PersonaRequest   {
  @JsonProperty("dni")
  private String dni = "";

  @JsonProperty("nombre")
  private String nombre = "";

  @JsonProperty("apellido")
  private String apellido = "";

  @JsonProperty("edad")
  private Integer edad = null;

  @JsonProperty("foto")
  private String foto = "";

  public PersonaRequest dni(String dni) {
    this.dni = dni;
    return this;
  }

   /**
   * Get dni
   * @return dni
  **/
  @ApiModelProperty(value = "")
  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public PersonaRequest nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

   /**
   * Get nombre
   * @return nombre
  **/
  @ApiModelProperty(value = "")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public PersonaRequest apellido(String apellido) {
    this.apellido = apellido;
    return this;
  }

   /**
   * Get apellido
   * @return apellido
  **/
  @ApiModelProperty(value = "")
  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public PersonaRequest edad(Integer edad) {
    this.edad = edad;
    return this;
  }

   /**
   * Get edad
   * @return edad
  **/
  @ApiModelProperty(value = "")
  public Integer getEdad() {
    return edad;
  }

  public void setEdad(Integer edad) {
    this.edad = edad;
  }

  public PersonaRequest foto(String foto) {
    this.foto = foto;
    return this;
  }

   /**
   * Get foto
   * @return foto
  **/
  @ApiModelProperty(value = "")
  public String getFoto() {
    return foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonaRequest personaRequest = (PersonaRequest) o;
    return Objects.equals(this.dni, personaRequest.dni) &&
        Objects.equals(this.nombre, personaRequest.nombre) &&
        Objects.equals(this.apellido, personaRequest.apellido) &&
        Objects.equals(this.edad, personaRequest.edad) &&
        Objects.equals(this.foto, personaRequest.foto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dni, nombre, apellido, edad, foto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonaRequest {\n");
    
    sb.append("    dni: ").append(toIndentedString(dni)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    apellido: ").append(toIndentedString(apellido)).append("\n");
    sb.append("    edad: ").append(toIndentedString(edad)).append("\n");
    sb.append("    foto: ").append(toIndentedString(foto)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

