
package com.mycompany.inmobiliariahernie.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inquilino implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //puede que no sea id_inquilino sino num_inquilino. Dsp lo veré si lo rechaza
    private int id_inquilino;
    private String apellido;
    private String nombre;
    private String dni;
    private String celular;
    private String alias;
    private String apellidogaran;
    private String nombregaran;
    private String dnigaran;
    private String celulargaran;
    private String observaciones;
    
    //@OneToOne cuando agregue la relación -> entidad Contrato

    public Inquilino() {
    }

    public Inquilino(int id_inquilino, String apellido, String nombre, String dni, String celular, String alias, String apellidogaran, String nombregaran, String dnigaran, String celulargaran, String observaciones) {
        this.id_inquilino = id_inquilino;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.celular = celular;
        this.alias = alias;
        this.apellidogaran = apellidogaran;
        this.nombregaran = nombregaran;
        this.dnigaran = dnigaran;
        this.celulargaran = celulargaran;
        this.observaciones = observaciones;
    }

    public int getId_inquilino() {
        return id_inquilino;
    }

    public void setId_inquilino(int id_inquilino) {
        this.id_inquilino = id_inquilino;
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

    public String getApellidogaran() {
        return apellidogaran;
    }

    public void setApellidogaran(String apellidogaran) {
        this.apellidogaran = apellidogaran;
    }

    public String getNombregaran() {
        return nombregaran;
    }

    public void setNombregaran(String nombregaran) {
        this.nombregaran = nombregaran;
    }

    public String getDnigaran() {
        return dnigaran;
    }

    public void setDnigaran(String dnigaran) {
        this.dnigaran = dnigaran;
    }

    public String getCelulargaran() {
        return celulargaran;
    }

    public void setCelulargaran(String celulargaran) {
        this.celulargaran = celulargaran;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
   
    
}
