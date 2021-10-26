/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viaja.colombia.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author GuerreroGomez
 */
@Entity
@Table( name="reserva" )
public class Reserva implements Serializable{
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name="id" )
    private long id;
    
    @OneToOne
    @JoinColumn( referencedColumnName = "identificacion", name = "usuario" ) 
    private Usuario usuario;
    
    @OneToOne
    @JoinColumn( referencedColumnName = "id", name = "destino" ) 
    private Destino destino;
    
    @Column( name="fechadesalida" )
    private String fechaDeSalida;
    
    @Column( name="fechadellegada" )
    private String fechaDeLlegada;
    
    @Column( name="numerodehabitacion" )
    private int numeroDeHabitacion;
    
    @Column( name="numerodepersonas" )
    private int numeroDePersonas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public String getFechaDeSalida() {
        return fechaDeSalida;
    }

    public void setFechaDeSalida(String fechaDeSalida) {
        this.fechaDeSalida = fechaDeSalida;
    }

    public String getFechaDeLlegada() {
        return fechaDeLlegada;
    }

    public void setFechaDeLlegada(String fechaDeLlegada) {
        this.fechaDeLlegada = fechaDeLlegada;
    }

    public int getNumeroDeHabitacion() {
        return numeroDeHabitacion;
    }

    public void setNumeroDeHabitacion(int numeroDeHabitacion) {
        this.numeroDeHabitacion = numeroDeHabitacion;
    }

    public int getNumeroDePersonas() {
        return numeroDePersonas;
    }

    public void setNumeroDePersonas(int numeroDePersonas) {
        this.numeroDePersonas = numeroDePersonas;
    }

}
