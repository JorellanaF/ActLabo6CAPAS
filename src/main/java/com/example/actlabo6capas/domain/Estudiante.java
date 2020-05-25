package com.example.actlabo6capas.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(generator = "estudiante_c_usuario_seq", strategy = GenerationType.AUTO)
    @Column(name = "c_usuario")
    private Integer codigoEstudiante;

    @Column(name = "nombre")
    @Size(message = "El nombre no debe tener mas de 50 caracteres", max = 50)
    @NotEmpty(message = "Este campo no puede estar vacio")
    private String nombre;

    @Column(name = "apellido")
    @Size(message = "El nombre no debe tener mas de 50 caracteres", max = 50)
    @NotEmpty(message = "Este campo no puede estar vacio")
    private String apellido;

    @Column(name = "carne")
    @Size(message = "El nombre no debe tener mas de 10 caracteres", max = 10)
    @NotEmpty(message = "Este campo no puede estar vacio")
    private String carne;

    @Column(name = "carrera")
    @Size(message = "El nombre no debe tener mas de 100 caracteres", max = 100)
    @NotEmpty(message = "Este campo no puede estar vacio")
    private String carrera;

    public Estudiante() {
    }

    public Integer getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(Integer codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
