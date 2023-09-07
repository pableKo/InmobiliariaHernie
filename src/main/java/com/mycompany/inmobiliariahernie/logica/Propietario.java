
package com.mycompany.inmobiliariahernie.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Propietario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_propietario;
    private String apellido;
    private String nombre;
    private String dni;
    private String celular;
    private String alias;

    public Propietario() {
    }

    public Propietario(int id_propietario, String apellido, String nombre, String dni, String celular, String alias) {
        this.id_propietario = id_propietario;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.celular = celular;
        this.alias = alias;
    }

    public int getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    
}
