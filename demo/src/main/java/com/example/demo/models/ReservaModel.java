package com.example.demo.models;
import javax.persistence.*;

@Entity
@Table(name="reserva")
public class ReservaModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long numId;

    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    private String lugDestino;
    private String lugLlegada;
    private String fechaSalida;
    private String fechaLlegada;
    private Interger numPersonas;

    public Long getNumId(){
        return numId;
    }
    public void setNumId(Long numId){
        this.numId = numId;
    }
    public String getNombres(){
        return nombres;
    }
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    public String getApellidos(){
        return apellidos;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public String getLugDestino(){
        return lugDestino;
    }
    public void setLugDestino(String lugDestino){
        this.lugDestino = lugDestino;
    }
    public String getLugLlegada(){
        return lugLlegada;
    }
    public void setLugLlegada(String lugLlegada){
        this.lugLlegada = lugLlegada;
    }
    public String getFechaSalida(){
        return fechaSalida;
    }
    public void setFechaSalida(String fechaSalida){
        this.fechaSalida = fechaSalida;
    }
    public String getFechaLlegada(){
        return fechaLlegada;
    }
    public void setFechaLlegada(String fechaLlegada){
        this.fechaLlegada = fechaLlegada;
    }
    public Integer getNumPersonas() {
        return numPersonas;
    }
    public void setNumPersonas(Integer numPersonas) {
        this.numPersonas = numPersonas;
    }  
}